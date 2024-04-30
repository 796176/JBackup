package jbackup.backend;

import java.io.*;

public interface BackupEngineInterface {
	void createBackup(File source, File dst, File[] exceptions) throws Exception;
	void createBackup(File source, File dst) throws Exception;
	BackupStatus getStatus();
	void interrupt();
}
