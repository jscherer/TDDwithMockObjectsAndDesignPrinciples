package jscherer.textconvertor;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;


public class UnicodeFileToHtmlTextConverterTest {
	
	UnicodeFileToHtmlTextConverter converter;
	Reader stringReader;
	
	@Before
	public void setUp() throws Exception {
		converter = new UnicodeFileToHtmlTextConverter(stringReader);
	}

	@Test
	public void testCreateUnicodeFileToHtmlTextConverter() {
		assertThat(converter, notNullValue());
	}

	@Test
	public void testConvertEmptyString() throws IOException {
		converter = new UnicodeFileToHtmlTextConverter(new StringReader(""));
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
		// TODO containsString 2 times ???
	}
	
	@Test
	public void testConvertWithCharactersToEscape() throws IOException {
			converter = new UnicodeFileToHtmlTextConverter(new StringReader("\"bread\" & \"butter\""));
			String actual = converter.convertToHtml();
			assertThat(actual, equalTo("&quot;bread&quot; &amp; &quot;butter&quot;<br />"));
	}
	
	
}
