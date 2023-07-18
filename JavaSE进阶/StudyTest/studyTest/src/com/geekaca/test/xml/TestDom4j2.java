package com.geekaca.test.xml;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class TestDom4j2 {
    public static void main(String[] args) throws DocumentException {
        SAXReader saxReader = new SAXReader();
        //Document 文档对象  对应整个XML
        File file = new File("books.xml");
        //把xml文件内容读进内存    ，把XML结构映射到一个类身上  Document 文档对象
        Document document = saxReader.read(file);
        //获取根节点（标签）
        Element rootElement = document.getRootElement();
        System.out.println(rootElement.getName());
//        提取所有名字为contact 的子元素
        List<Element> elementList = rootElement.elements("book");
        List<Book> bookList = new ArrayList<>();
        for(Element books : elementList){
            // 8、每个XML的子元素Element都是一个联系人对象
            Book book = new Book();
            book.setId(Integer.valueOf(books.attributeValue("id")));
            book.setDesc(String.valueOf(books.attributeValue("desc")));
            //拿到元素文本值，而且去掉空格
            book.setName(books.elementTextTrim("name"));
            book.setAuthor(books.elementTextTrim("author"));
            book.setSale(books.elementText("sale"));
            bookList.add(book);
            //属性
            Attribute idAttri = books.attribute("id");
            String value = idAttri.getValue();
            System.out.println("属性id 值：" + value);
            //获取 book元素 下级元素name的值
            String name = books.elementText("name");
            System.out.println(name);
        }

        bookList.forEach((ct)-> System.out.println(ct));
    }
}
