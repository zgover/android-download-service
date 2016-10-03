// Zachary Gover
// MDF3 - 1610
// Storage

package com.gover.zachary.downloadservice.models;

import android.content.Context;

import java.io.*;
import java.net.URL;

public class Storage {

	public final String URL_BASE = "http://i.imgur.com/";

	private static Storage instance;
	private Context context;

	private Storage(Context _context){ context = _context; }

	public static Storage newInstance(Context _context) {
		if (instance != null) {
			return instance;
		}

		instance = new Storage(_context);
		return instance;
	}

	public byte[] readImage(String imageName, boolean ext) {
		// Get the input stream
		BufferedInputStream buffInputStream = null;
		FileInputStream inputStream = null;
		ByteArrayOutputStream out = null;
		byte[] response = null;

		try {
			// Open the devices input streams so we may read the file
			if (ext) {

				inputStream = context.openFileInput(imageName);
				out = new ByteArrayOutputStream();
				byte[] buf = new byte[1024];
				int i;

				while((i = inputStream.read(buf)) != -1) {
					out.write(buf, 0, i);
				}

			} else {

				URL fileUrl = new URL(URL_BASE + imageName);
				buffInputStream = new BufferedInputStream(fileUrl.openStream());
				out = new ByteArrayOutputStream();
				byte[] buf = new byte[1024];
				int i;

				while((i = buffInputStream.read(buf)) != -1) {
					out.write(buf, 0, i);
				}

			}

			response = out.toByteArray();

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// Close the input streams
			if (out != null) {
				try {
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

			if (buffInputStream != null) {
				try {
					buffInputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

			if (inputStream != null) {
				try {
					inputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		return response;
	}

	private void saveImage(String imageName, byte[] img) {
		// Get the file output stream
		FileOutputStream outputStream = null;

		try {
			// Open the devices output stream so we may save to it
			outputStream = context.openFileOutput(imageName, context.MODE_PRIVATE);
			outputStream.write(img);

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// Close the output streams
			if (outputStream != null) {
				try {
					outputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
