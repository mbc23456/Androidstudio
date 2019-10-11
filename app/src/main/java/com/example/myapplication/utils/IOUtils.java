package com.example.myapplication.utils;

import android.util.Xml;
import android.widget.ImageView;
import com.example.myapplication.entity.ExerciseDetail;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class IOUtils<list> {
    list<ExerciseDetail> details = null;
    ExerciseDetail detail = null;
    //创建一个解析器
    XmlPullParser parser = Xml.newPullParser();
    //2.设置输入源
    parser.setInput(is.StandardCharsets.UTF_8.toString());
    //3.根据EventType类型，判断节点名称，解析数据，将输入放入集合
    int evevtType = parser.getEventType();
    while(evenType! =XmlPullParser.END_DOCUMENT)

    {
        String nodeName = parser.getName();
        switch (evevtType) {
            case XmlPullParser.START_TAG
                ;
                if ("infos".equals(nodeName)) {
                    details = new ExerciseDetail();
                    int index;
                    String ids = parser.getAttributeValue(index:0);
                    detail.setSubjectId(Integer.parseInt(ids));


                } else if ("exercises".equals(nodeName)) {
                    try {
                        assert details != null;
                        details.setSubject(parser.nextText());
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (XmlPullParserException e) {
                        e.printStackTrace();
                    }

                } else if ("a".equals(nodeName)) {
                    try {
                        detail.setA(parser.nextText());
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (XmlPullParserException e) {
                        e.printStackTrace();
                    }

                } else if ("b".equals(nodeName)) {
                    try {
                        detail.setB(parser.nextText());
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (XmlPullParserException e) {
                        e.printStackTrace();
                    }

                } else if ("c".equals(nodeName)) {
                    try {
                        detail.setC(parser.nextText());
                    } catch (IOException e) {

                    } catch (XmlPullParserException e) {
                        e.printStackTrace();
                    }

                } else if ("d".equals(nodeName)) {
                    try {
                        detail.setD(parser.nextText());
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (XmlPullParserException e) {
                        e.printStackTrace();
                    }

                } else if ("answer".equals(nodeName)) {
                    try {
                        detail.setAnswer(Integer.parseInt(parser.nextText()));
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (XmlPullParserException e) {
                        e.printStackTrace();
                    }
                }
                break;
            case XmlPullParser.END_TAG:
                if ("exercise".equals(nodeName)) {
                    details.add(detail);
                    detail = null;

                }
                break;
        }
        try {
            evevtType = parser.next();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        }
    }
    return details;
}
public static void setABCDEnable(boolean value, ImageView ivA,ImageView ivB,ImageView ivC,ImageView ivD){
    ivA.setEnabled(value);
    ivB.setEnabled(value);
    ivC.setEnabled(value);
    ivD.setEnabled(value);
}
}
