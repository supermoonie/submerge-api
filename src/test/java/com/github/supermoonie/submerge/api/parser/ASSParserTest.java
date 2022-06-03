package com.github.supermoonie.submerge.api.parser;

import com.github.supermoonie.submerge.api.subtitle.common.TimedTextFile;
import org.apache.commons.io.FilenameUtils;
import org.junit.Test;

import java.io.File;

/**
 * @author Administrator
 * @since 2022/6/3
 */
public class ASSParserTest {

    @Test
    public void parse() {
//        File assFile = new File("F:\\BaiduSyncdisk\\素材\\字幕\\Aqui_no_hay_quien_viva_1.ass");
        File assFile = new File("D:\\java\\FastCut\\temp\\20221806185304-5.ass");
        SubtitleParser parser = ParserFactory.getParser(FilenameUtils.getExtension(assFile.getName()));
        TimedTextFile timedText = parser.parse(assFile);
        System.out.println(timedText.toString());
    }

}