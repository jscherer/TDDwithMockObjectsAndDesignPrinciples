package jscherer.textconvertor;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import java.io.IOException;
import java.io.StringReader;

import org.junit.Before;
import org.junit.Test;

public class UnicodeFileToHtmlTextConverterTest {
	
	UnicodeFileToHtmlTextConverter converter;
	
	@Before
	public void setUp() throws Exception {
		converter = new UnicodeFileToHtmlTextConverter(new StringReader(""));
	}

	@Test
	public void testCreateUnicodeFileToHtmlTextConverter() {
		assertThat(converter, notNullValue());
	}

	@Test
	public void testConvertEmptyString() throws IOException {
		assertThat(converter.convertToHtml(), equalTo(""));
	}
	
	@Test
	public void testConvertSpace() throws IOException {
		converter = new UnicodeFileToHtmlTextConverter(new StringReader(" "));
		String actual = converter.convertToHtml();
		assertThat(actual, equalTo(" <br />"));
		assertThat(actual, containsString("br"));
	}
	
	@Test
	public void testConvertTwoLines() throws IOException {
		converter = new UnicodeFileToHtmlTextConverter(new StringReader(" \n "));
		String actual = converter.convertToHtml();
		assertThat(actual, equalTo(" <br /> <br />"));
		// TODO containsString 2 times, matcher ???
	}
	
	@Test
	public void testConvertWithCharactersToEscape() throws IOException {
			converter = new UnicodeFileToHtmlTextConverter(new StringReader("\"bread\" & \"butter\""));
			String actual = converter.convertToHtml();
			assertThat(actual, equalTo("&quot;bread&quot; &amp; &quot;butter&quot;<br />"));
	}

}
