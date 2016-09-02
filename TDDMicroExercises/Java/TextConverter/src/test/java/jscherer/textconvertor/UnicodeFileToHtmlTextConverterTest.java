package jscherer.textconvertor;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.LinkedList;

import org.junit.Before;
import org.junit.Test;


public class UnicodeFileToHtmlTextConverterTest {
	
	static final String expedtedHtml = 
		"&lt;!doctype html&gt;<br />&lt;html&gt;<br />&lt;head&gt;<br />&lt;meta charset=&quot;utf-8&quot;&gt;<br />&lt;title&gt;Titelzeile&lt;/title&gt;<br />&lt;/head&gt;<br />&lt;body&gt;<br />&lt;p&gt;Text Paragraph 1&lt;/p&gt;<br />&lt;/body&gt;<br />&lt;/html&gt;<br />";

	
	UnicodeFileToHtmlTextConverter converter;
	BufferedReader htmlReader;
	
	@Before
	public void setUp() throws Exception {
		htmlReader = new MockHtmlReader();
		converter = new UnicodeFileToHtmlTextConverter(htmlReader);
	}

	@Test
	public void testCreateUnicodeFileToHtmlTextConverter() {
		assertThat(converter, notNullValue());
	}

	@Test
	public void testConvertToHtml() throws IOException {
		assertThat(expedtedHtml, is(converter.convertToHtml()));
	}
	
	class MockHtmlReader extends BufferedReader {
		
		/*
		 * Simple HTML String List
		 *
		 */
		static final String DOCTYPE = 		"<!doctype html>";
		static final String HTML = 			"<html>";
		static final String HEAD = 				"<head>";
		static final String META = 					"<meta charset=\"utf-8\">";
		static final String TITLE = 				"<title>Titelzeile</title>";
		static final String HEAD_END = 			"</head>";
		static final String BODY = 				"<body>";
		static final String P1 = 					"<p>Text Paragraph 1</p>";
		static final String BODY_END = 			"</body>";
		static final String HTML_END = 		"</html>";
		
		LinkedList<String> html = new LinkedList<String>();

		public MockHtmlReader() {
			super(new Reader() {
				@Override
				public int read(char[] cbuf, int off, int len) throws IOException {
					return 0;
				}
				@Override
				public void close() throws IOException {					
				}
			});
			initHtml();
		}
		
		/**
		 * Retrieves and removes the first line from the html list, or returns null if this list is empty.
		 */
		@Override
		public String readLine() throws IOException {
			return html.pollFirst();
		}
		
		private void initHtml() {
			initHeader();
			initContent();
			initFooter();
		}

		private void initHeader() {
			html.add(DOCTYPE);
			html.add(HTML);
			html.add(HEAD);
			html.add(META);
			html.add(TITLE);
			html.add(HEAD_END);
			html.add(BODY);
		}

		private void initContent() {
			html.add(P1);		
		}
		
		private void initFooter() {
			html.add(BODY_END);
			html.add(HTML_END);
		}
	}
}
