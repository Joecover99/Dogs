package helpers;

import javax.swing.JLabel;

import util.image.ImageUtil;

public class JExtImage extends JLabel {
	public JExtImage(Object o, String imageUri) {
		super(ImageUtil.getImageIcon(o, imageUri));
	}
}
