package com.future.spring_data_jpa.pdf.untemplates;

import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.GrayColor;
import com.itextpdf.text.pdf.PdfPageEventHelper;
import com.itextpdf.text.pdf.PdfWriter;

/**
 * Copyright (C) 2020
 * <p>
 * 版权所有。
 * <p>
 * 类名　　  :Watermark
 * 功能概要  :水印
 * 做成日期  :2020-12-17  huangsl
 */
public class Watermark extends PdfPageEventHelper {

    Font FONT = new Font(Font.FontFamily.HELVETICA, 30, Font.BOLD, new GrayColor(0.95f));
    private String waterCont;//水印内容
    public Watermark() {

    }
    public Watermark(String waterCont) {
        this.waterCont = waterCont;
    }

    @Override
    public void onEndPage(PdfWriter writer, Document document) {
        for(int i=0 ; i<5; i++) {
            for(int j=0; j<5; j++) {
                ColumnText.showTextAligned(writer.getDirectContentUnder(),
                        Element.ALIGN_CENTER,
                        new Phrase(this.waterCont == null ? "HELLO WORLD" : this.waterCont, FONT),
                        (50.5f+i*350),
                        (40.0f+j*150),
                        writer.getPageNumber() % 2 == 1 ? 45 : -45);
            }
        }
    }
}
