package mdlaf.utils;

import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.font.TextAttribute;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class MaterialFonts {

	private static final Map<TextAttribute, Object> fontSettings = new HashMap<TextAttribute, Object> ();
	public static final Font BLACK = loadFont ("/fonts/NotoSansCJKsc-Black.ttf");
	public static final Font BLACK_ITALIC = loadFont ("/fonts/NotoSans-BlackItalic.ttf");
	public static final Font BOLD = loadFont ("/fonts/NotoSansCJKsc-Bold.ttf");
	public static final Font BOLD_ITALIC = loadFont ("/fonts/NotoSans-BoldItalic.ttf");
	public static final Font ITALIC = loadFont ("/fonts/NotoSans-Italic.ttf");
	public static final Font LIGHT = loadFont ("/fonts/NotoSansCJKsc-Light.ttf");
	public static final Font LIGHT_ITALIC = loadFont ("/fonts/NotoSans-LightItalic.ttf");
	public static final Font MEDIUM = loadFont ("/fonts/NotoSansCJKsc-Medium.ttf");
	public static final Font MEDIUM_ITALIC = loadFont ("/fonts/NotoSans-MediumItalic.ttf");
	public static final Font REGULAR = loadFont ("/fonts/NotoSansCJKsc-Regular.ttf");
	public static final Font THIN = loadFont ("/fonts/NotoSans-Thin.ttf");
	public static final Font THIN_ITALIC = loadFont ("/fonts/NotoSans-ThinItalic.ttf");

	private static Font loadFont (String fontPath) {
		if (fontSettings.isEmpty ()) {
			fontSettings.put (TextAttribute.SIZE, 12f);
			fontSettings.put (TextAttribute.KERNING, TextAttribute.KERNING_ON);
		}
                
		try (InputStream inputStream = MaterialFonts.class.getResourceAsStream (fontPath)) {
			return Font.createFont (Font.TRUETYPE_FONT, inputStream).deriveFont (fontSettings);
		}
		catch (IOException | FontFormatException e) {
			e.printStackTrace ();
			throw new RuntimeException ("Font " + fontPath + " wasn't loaded");
		}
	}
}
