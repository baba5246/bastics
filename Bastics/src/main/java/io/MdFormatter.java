package io;

import bastics.Statistics;

import java.io.InputStream;

/**
 * Markdown format class
 */
public class MdFormatter {

    private static final String RECORD_COUNT = "!record_count";

    public static String format(Statistics result) throws Exception {

        StringBuilder sb = new StringBuilder();

        InputStream is = (InputStream) MdFormatter.class.getClassLoader().getResource("template/template.md").getContent();
        String template = FileIO.readFile(is);
        sb.append(template);

        // 行数カウント
        String countFormat = String.format("| count | " + result.getRecordCount() + " |\n");
        int index = sb.indexOf(RECORD_COUNT);
        sb.insert(index, countFormat);

        String finalFormat = sb.toString();
        finalFormat = finalFormat.replace(RECORD_COUNT, "");
        return finalFormat;
    }
}
