package com.jfinal.ext.render;

import com.jfinal.render.FileRender;

import java.io.File;

/**
 * Created by 0x0001 on 14-7-17.
 */
public class TempFileRender extends FileRender {
	private File file;
	public TempFileRender(File file) {
		super(file);
		this.file = file;
	}

	public TempFileRender(String fileName) {
		super(fileName);
		this.file = new File(fileName);
	}


	@Override
	public void render() {
		try {
			super.render();
		} finally {
			if (file != null) {
				if (!file.delete()) {
					file.deleteOnExit();
				}
			}
		}
	}
}
