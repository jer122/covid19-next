//
// �� ������ JAXB(JavaTM Architecture for XML Binding) ���� ���� 2.3.1 ������ ���� �����Ǿ����ϴ�. 
// <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a>�� �����Ͻʽÿ�. 
// �� ������ �����ϸ� �ҽ� ��Ű���� ���������� �� ���� ������ �սǵ˴ϴ�. 
// ���� ��¥: 2021.08.13 �ð� 07:28:50 PM KST 
//


package com.covid19next.model.covidinfo;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>anonymous complex type�� ���� Java Ŭ�����Դϴ�.
 * 
 * <p>���� ��Ű�� ������ �� Ŭ������ ���ԵǴ� �ʿ��� �������� �����մϴ�.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="header"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="resultCode" type="{http://www.w3.org/2001/XMLSchema}unsignedByte"/&gt;
 *                   &lt;element name="resultMsg" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="body"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="items"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;complexContent&gt;
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                           &lt;sequence&gt;
 *                             &lt;element name="item" maxOccurs="unbounded"&gt;
 *                               &lt;complexType&gt;
 *                                 &lt;complexContent&gt;
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                                     &lt;sequence&gt;
 *                                       &lt;element name="content" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                                       &lt;element name="contentHtml" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                                       &lt;element name="countryEnName" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                                       &lt;element name="countryName" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                                       &lt;element name="fileUrl" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                                       &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                                       &lt;element name="title" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                                       &lt;element name="wrtDt" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
 *                                     &lt;/sequence&gt;
 *                                   &lt;/restriction&gt;
 *                                 &lt;/complexContent&gt;
 *                               &lt;/complexType&gt;
 *                             &lt;/element&gt;
 *                           &lt;/sequence&gt;
 *                         &lt;/restriction&gt;
 *                       &lt;/complexContent&gt;
 *                     &lt;/complexType&gt;
 *                   &lt;/element&gt;
 *                   &lt;element name="numOfRows" type="{http://www.w3.org/2001/XMLSchema}unsignedByte"/&gt;
 *                   &lt;element name="pageNo" type="{http://www.w3.org/2001/XMLSchema}unsignedByte"/&gt;
 *                   &lt;element name="totalCount" type="{http://www.w3.org/2001/XMLSchema}unsignedByte"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "header",
    "body"
})
@XmlRootElement(name = "response")
public class CovidInformationResponse {

    @XmlElement(required = true)
    protected Header header;
    @XmlElement(required = true)
    protected Body body;

    /**
     * header �Ӽ��� ���� �����ɴϴ�.
     * 
     * @return
     *     possible object is
     *     {@link Header }
     *     
     */
    public Header getHeader() {
        return header;
    }

    /**
     * header �Ӽ��� ���� �����մϴ�.
     * 
     * @param value
     *     allowed object is
     *     {@link Header }
     *     
     */
    public void setHeader(Header value) {
        this.header = value;
    }

    /**
     * body �Ӽ��� ���� �����ɴϴ�.
     * 
     * @return
     *     possible object is
     *     {@link Body }
     *     
     */
    public Body getBody() {
        return body;
    }

    /**
     * body �Ӽ��� ���� �����մϴ�.
     * 
     * @param value
     *     allowed object is
     *     {@link Body }
     *     
     */
    public void setBody(Body value) {
        this.body = value;
    }


    /**
     * <p>anonymous complex type�� ���� Java Ŭ�����Դϴ�.
     * 
     * <p>���� ��Ű�� ������ �� Ŭ������ ���ԵǴ� �ʿ��� �������� �����մϴ�.
     * 
     * <pre>
     * &lt;complexType&gt;
     *   &lt;complexContent&gt;
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *       &lt;sequence&gt;
     *         &lt;element name="items"&gt;
     *           &lt;complexType&gt;
     *             &lt;complexContent&gt;
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                 &lt;sequence&gt;
     *                   &lt;element name="item" maxOccurs="unbounded"&gt;
     *                     &lt;complexType&gt;
     *                       &lt;complexContent&gt;
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                           &lt;sequence&gt;
     *                             &lt;element name="content" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
     *                             &lt;element name="contentHtml" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
     *                             &lt;element name="countryEnName" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
     *                             &lt;element name="countryName" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
     *                             &lt;element name="fileUrl" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
     *                             &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
     *                             &lt;element name="title" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
     *                             &lt;element name="wrtDt" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
     *                           &lt;/sequence&gt;
     *                         &lt;/restriction&gt;
     *                       &lt;/complexContent&gt;
     *                     &lt;/complexType&gt;
     *                   &lt;/element&gt;
     *                 &lt;/sequence&gt;
     *               &lt;/restriction&gt;
     *             &lt;/complexContent&gt;
     *           &lt;/complexType&gt;
     *         &lt;/element&gt;
     *         &lt;element name="numOfRows" type="{http://www.w3.org/2001/XMLSchema}unsignedByte"/&gt;
     *         &lt;element name="pageNo" type="{http://www.w3.org/2001/XMLSchema}unsignedByte"/&gt;
     *         &lt;element name="totalCount" type="{http://www.w3.org/2001/XMLSchema}unsignedByte"/&gt;
     *       &lt;/sequence&gt;
     *     &lt;/restriction&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "items",
        "numOfRows",
        "pageNo",
        "totalCount"
    })
    public static class Body {

        @XmlElement(required = true)
        protected Items items;
        @XmlSchemaType(name = "unsignedByte")
        protected short numOfRows;
        @XmlSchemaType(name = "unsignedByte")
        protected short pageNo;
        @XmlSchemaType(name = "unsignedByte")
        protected short totalCount;

        /**
         * items �Ӽ��� ���� �����ɴϴ�.
         * 
         * @return
         *     possible object is
         *     {@link Items }
         *     
         */
        public Items getItems() {
            return items;
        }

        /**
         * items �Ӽ��� ���� �����մϴ�.
         * 
         * @param value
         *     allowed object is
         *     {@link Items }
         *     
         */
        public void setItems(Items value) {
            this.items = value;
        }

        /**
         * numOfRows �Ӽ��� ���� �����ɴϴ�.
         * 
         */
        public short getNumOfRows() {
            return numOfRows;
        }

        /**
         * numOfRows �Ӽ��� ���� �����մϴ�.
         * 
         */
        public void setNumOfRows(short value) {
            this.numOfRows = value;
        }

        /**
         * pageNo �Ӽ��� ���� �����ɴϴ�.
         * 
         */
        public short getPageNo() {
            return pageNo;
        }

        /**
         * pageNo �Ӽ��� ���� �����մϴ�.
         * 
         */
        public void setPageNo(short value) {
            this.pageNo = value;
        }

        /**
         * totalCount �Ӽ��� ���� �����ɴϴ�.
         * 
         */
        public short getTotalCount() {
            return totalCount;
        }

        /**
         * totalCount �Ӽ��� ���� �����մϴ�.
         * 
         */
        public void setTotalCount(short value) {
            this.totalCount = value;
        }


        /**
         * <p>anonymous complex type�� ���� Java Ŭ�����Դϴ�.
         * 
         * <p>���� ��Ű�� ������ �� Ŭ������ ���ԵǴ� �ʿ��� �������� �����մϴ�.
         * 
         * <pre>
         * &lt;complexType&gt;
         *   &lt;complexContent&gt;
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *       &lt;sequence&gt;
         *         &lt;element name="item" maxOccurs="unbounded"&gt;
         *           &lt;complexType&gt;
         *             &lt;complexContent&gt;
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *                 &lt;sequence&gt;
         *                   &lt;element name="content" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
         *                   &lt;element name="contentHtml" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
         *                   &lt;element name="countryEnName" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
         *                   &lt;element name="countryName" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
         *                   &lt;element name="fileUrl" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
         *                   &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
         *                   &lt;element name="title" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
         *                   &lt;element name="wrtDt" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
         *                 &lt;/sequence&gt;
         *               &lt;/restriction&gt;
         *             &lt;/complexContent&gt;
         *           &lt;/complexType&gt;
         *         &lt;/element&gt;
         *       &lt;/sequence&gt;
         *     &lt;/restriction&gt;
         *   &lt;/complexContent&gt;
         * &lt;/complexType&gt;
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "item"
        })
        public static class Items {

            @XmlElement(required = true)
            protected List<Item> item;

            /**
             * Gets the value of the item property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the item property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getItem().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link Item }
             * 
             * 
             */
            public List<Item> getItem() {
                if (item == null) {
                    item = new ArrayList<Item>();
                }
                return this.item;
            }


            /**
             * <p>anonymous complex type�� ���� Java Ŭ�����Դϴ�.
             * 
             * <p>���� ��Ű�� ������ �� Ŭ������ ���ԵǴ� �ʿ��� �������� �����մϴ�.
             * 
             * <pre>
             * &lt;complexType&gt;
             *   &lt;complexContent&gt;
             *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
             *       &lt;sequence&gt;
             *         &lt;element name="content" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
             *         &lt;element name="contentHtml" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
             *         &lt;element name="countryEnName" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
             *         &lt;element name="countryName" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
             *         &lt;element name="fileUrl" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
             *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
             *         &lt;element name="title" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
             *         &lt;element name="wrtDt" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
             *       &lt;/sequence&gt;
             *     &lt;/restriction&gt;
             *   &lt;/complexContent&gt;
             * &lt;/complexType&gt;
             * </pre>
             * 
             * 
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "", propOrder = {
                "content",
                "contentHtml",
                "countryEnName",
                "countryName",
                "fileUrl",
                "id",
                "title",
                "wrtDt"
            })
            public static class Item {

                @XmlElement(required = true)
                protected String content;
                @XmlElement(required = true)
                protected String contentHtml;
                @XmlElement(required = true)
                protected String countryEnName;
                @XmlElement(required = true)
                protected String countryName;
                @XmlElement(required = true)
                protected String fileUrl;
                @XmlElement(required = true)
                protected String id;
                @XmlElement(required = true)
                protected String title;
                @XmlElement(required = true)
                @XmlSchemaType(name = "date")
                protected XMLGregorianCalendar wrtDt;

                /**
                 * content �Ӽ��� ���� �����ɴϴ�.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getContent() {
                    return content;
                }

                /**
                 * content �Ӽ��� ���� �����մϴ�.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setContent(String value) {
                    this.content = value;
                }

                /**
                 * contentHtml �Ӽ��� ���� �����ɴϴ�.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getContentHtml() {
                    return contentHtml;
                }

                /**
                 * contentHtml �Ӽ��� ���� �����մϴ�.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setContentHtml(String value) {
                    this.contentHtml = value;
                }

                /**
                 * countryEnName �Ӽ��� ���� �����ɴϴ�.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getCountryEnName() {
                    return countryEnName;
                }

                /**
                 * countryEnName �Ӽ��� ���� �����մϴ�.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setCountryEnName(String value) {
                    this.countryEnName = value;
                }

                /**
                 * countryName �Ӽ��� ���� �����ɴϴ�.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getCountryName() {
                    return countryName;
                }

                /**
                 * countryName �Ӽ��� ���� �����մϴ�.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setCountryName(String value) {
                    this.countryName = value;
                }

                /**
                 * fileUrl �Ӽ��� ���� �����ɴϴ�.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getFileUrl() {
                    return fileUrl;
                }

                /**
                 * fileUrl �Ӽ��� ���� �����մϴ�.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setFileUrl(String value) {
                    this.fileUrl = value;
                }

                /**
                 * id �Ӽ��� ���� �����ɴϴ�.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getId() {
                    return id;
                }

                /**
                 * id �Ӽ��� ���� �����մϴ�.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setId(String value) {
                    this.id = value;
                }

                /**
                 * title �Ӽ��� ���� �����ɴϴ�.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getTitle() {
                    return title;
                }

                /**
                 * title �Ӽ��� ���� �����մϴ�.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setTitle(String value) {
                    this.title = value;
                }

                /**
                 * wrtDt �Ӽ��� ���� �����ɴϴ�.
                 * 
                 * @return
                 *     possible object is
                 *     {@link XMLGregorianCalendar }
                 *     
                 */
                public XMLGregorianCalendar getWrtDt() {
                    return wrtDt;
                }

                /**
                 * wrtDt �Ӽ��� ���� �����մϴ�.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link XMLGregorianCalendar }
                 *     
                 */
                public void setWrtDt(XMLGregorianCalendar value) {
                    this.wrtDt = value;
                }

            }

        }

    }


    /**
     * <p>anonymous complex type�� ���� Java Ŭ�����Դϴ�.
     * 
     * <p>���� ��Ű�� ������ �� Ŭ������ ���ԵǴ� �ʿ��� �������� �����մϴ�.
     * 
     * <pre>
     * &lt;complexType&gt;
     *   &lt;complexContent&gt;
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *       &lt;sequence&gt;
     *         &lt;element name="resultCode" type="{http://www.w3.org/2001/XMLSchema}unsignedByte"/&gt;
     *         &lt;element name="resultMsg" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
     *       &lt;/sequence&gt;
     *     &lt;/restriction&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "resultCode",
        "resultMsg"
    })
    public static class Header {

        @XmlSchemaType(name = "unsignedByte")
        protected short resultCode;
        @XmlElement(required = true)
        protected String resultMsg;

        /**
         * resultCode �Ӽ��� ���� �����ɴϴ�.
         * 
         */
        public short getResultCode() {
            return resultCode;
        }

        /**
         * resultCode �Ӽ��� ���� �����մϴ�.
         * 
         */
        public void setResultCode(short value) {
            this.resultCode = value;
        }

        /**
         * resultMsg �Ӽ��� ���� �����ɴϴ�.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getResultMsg() {
            return resultMsg;
        }

        /**
         * resultMsg �Ӽ��� ���� �����մϴ�.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setResultMsg(String value) {
            this.resultMsg = value;
        }

    }

}
