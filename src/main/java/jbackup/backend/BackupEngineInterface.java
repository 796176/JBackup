package jbackup.backend;

import java.io.*;

public interface BackupEngineInterface {
	void createBackup(File source, File dst, File[] exceptions);
	void createBackup(File source, File dst);
	BackupStatus getStatus();
}
