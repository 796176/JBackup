package jbackup.backend;

public class BackupStatus {
	private boolean isFinished;
	private String[] finishedFiles;
	private String currentFile;
	private long progress;
	private long total;
	private long currentProgress;
	private long currentTotal;
	private File[] allFiles;
	private Thread thread;

	void setIsFinished(boolean v){
		isFinished = v;
	}

	public boolean isFinished() {
		return isFinished;
	}

	void setFinishedFiles(String[] v){
		assert v != null;
		finishedFiles = v;
	}

	public String[] getFinishedFiles() {
		return finishedFiles;
	}

	void setCurrentFile(String v){
		assert v != null;
		currentFile = v;
	}

	public String getCurrentFile() {
		return currentFile;
	}

	void setProgress(long v){
		assert v >= 0;
		progress = v;
	}

	public long getProgress() {
		return progress;
	}

	void setTotal(long v){
		assert v > 0;
		total = v;
	}

	public long getTotal() {
		return total;
	}

	void setCurrentProgress(long v){
		assert v >= 0;
		currentProgress = v;
	}

	public long getCurrentProgress() {
		return currentProgress;
	}

	void setCurrentTotal(long v) {
		assert v > 0;
		currentTotal = v;
	}

	public long getCurrentTotal() {
		return currentTotal;
	}

	void setAllFiles(File[] v) {
		assert v != null;
		allFiles = v;
	}

	public File[] getAllFiles() {
		return allFiles;
	}

	void setThread(Thread v) {
		assert v != null;
		thread = v;
	}

	Thread getThread() {
		return thread;
	}
}
