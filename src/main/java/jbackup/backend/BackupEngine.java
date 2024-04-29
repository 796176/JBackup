package jbackup.backend;

import java.io.File;

public class BackupEngine implements BackupEngineInterface {
	@Override
	public void createBackup(File source, File dst, File[] exceptions) {

	}

	@Override
	public void createBackup(File source, File dst) {

	}

	@Override
	public BackupStatus getStatus() {
		return null;
	}
}
