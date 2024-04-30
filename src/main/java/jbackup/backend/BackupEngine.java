package jbackup.backend;

import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.*;
import java.util.*;

public class BackupEngine implements BackupEngineInterface, Runnable {
	private BackupStatus status = new BackupStatus();
	private File dst = null;
	private File src = null;
	private boolean interrupted = false;

	private Exception exception;

	@Override
	public void createBackup(File source, File destination, File[] exceptions) throws IOException {
		assert source != null && dst != null && exceptions != null;
		dst = destination;
		src = source;
		Arrays.sort(exceptions);
		Path sourcePath = source.toPath();
		FileVisitor<Path> fileVisitor = new SimpleFileVisitor<>() {
			@Override
			public FileVisitResult preVisitDirectory(Path path, BasicFileAttributes attributes) throws IOException{
				if (Arrays.binarySearch(exceptions, path.toFile()) >= 0) {
					return FileVisitResult.SKIP_SUBTREE;
				}
				LinkedList<File> ll = status.getAllFiles();
				ll.add(path.toFile());
				return FileVisitResult.CONTINUE;
			}
			@Override
			public FileVisitResult visitFile(Path path, BasicFileAttributes attributes) throws IOException {
				if (Arrays.binarySearch(exceptions, path.toFile()) >= 0) {
					return FileVisitResult.CONTINUE;
				}
				LinkedList<File> ll = status.getAllFiles();
				ll.add(path.toFile());
				status.setTotal(status.getTotal() + Files.size(path));
				return FileVisitResult.CONTINUE;
			}
		};
		Files.walkFileTree(sourcePath, fileVisitor);

		Thread thread = new Thread(this);
		thread.start();
		status.setThread(thread);
	}

	@Override
	public void createBackup(File source, File dst) throws IOException {
		createBackup(source, dst, new File[]{});
	}

	@Override
	public BackupStatus getStatus() {
		return status;
	}

	@Override
	public void run() {
		try {
			Iterator<File> files = status.getAllFiles().iterator();
			while (!interrupted && files.hasNext()) {
				File currentFile = files.next();
				status.setCurrentFile(currentFile);
				File currentFileDst = new File(dst, currentFile.getAbsolutePath().replace(src.getParent(), ""));

				if (currentFile.isDirectory()) {
					currentFileDst.mkdir();
					setAttributes(currentFile.toPath(), currentFileDst.toPath());
					status.getFinishedFiles().add(currentFile);
					continue;
				}

				int bsize = 1024 * 8;
				status.setCurrentTotal(Files.size(currentFile.toPath()));
				try (
					BufferedInputStream bis = new BufferedInputStream(new FileInputStream(currentFile), bsize);
					BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(currentFileDst), bsize)
				) {
					byte[] buffer = new byte[1024];
					int byteRead;
					do {
						if (interrupted) return;
						byteRead = bis.readNBytes(buffer, 0, buffer.length);
						status.setCurrentProgress(status.getCurrentProgress() + byteRead);
						bos.write(buffer, 0, byteRead);
					} while (byteRead != 0);
				}
				setAttributes(currentFile.toPath(), currentFileDst.toPath());
				status.getFinishedFiles().add(currentFile);
				status.setCurrentProgress(0);
				status.setProgress(status.getProgress() + status.getCurrentTotal());
				status.setCurrentTotal(0);
			}
		} catch (Exception e) {
			exception = e;
		}

		status.setIsFinished(true);
	}

	@Override
	public void interrupt(){
		interrupted = true;
		try {
			status.getThread().join();
		} catch (InterruptedException ignored) {}
	}

	private void setAttributes(Path currentPath, Path currentPathDst) throws IOException{
	}
}
