package com.geekaca.test.xml;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class TestDom4j {
    /**
     * 了解 Java如何读取XML
     */
    public static void main(String[] args) throws DocumentException {
        SAXReader saxReader = new SAXReader();
        //Document 文档对象  对应整个XML
//        InputStream ips = TestDom4j.class.getResourceAsStream("contacts.xml");
        File file = new File("contacts.xml");
        //把xml文件内容读进内存    ，把XML结构映射到一个类身上  Document 文档对象
        Document document = saxReader.read(file);
        //获取根节点（标签）
        Element rootElement = document.getRootElement();
        System.out.println(rootElement.getName());
//        提取所有名字为contact 的子元素
        List<Element> elementList = rootElement.elements("contact");
        List<Contact> contactList = new ArrayList<>();
        for(Element contact : elementList){
            // 8、每个XML的子元素Element都是一个联系人对象
            Contact conct = new Contact();
            conct.setId(Integer.valueOf(contact.attributeValue("id")));
            conct.setVip(Boolean.valueOf(contact.attributeValue("vip")));
            //拿到元素文本值，而且去掉空格
            conct.setName(contact.elementTextTrim("name"));
            conct.setGender(contact.elementTextTrim("gender").charAt(0));
            conct.setEmail(contact.elementText("email"));
            contactList.add(conct);
            //属性
            Attribute idAttri = contact.attribute("id");
            String value = idAttri.getValue();
            System.out.println("属性id 值：" + value);
            //获取 contact元素 下级元素name的值
            String name = contact.elementText("name");
            System.out.println(name);
        }

        contactList.forEach((ct)-> System.out.println(ct));
    }
}
