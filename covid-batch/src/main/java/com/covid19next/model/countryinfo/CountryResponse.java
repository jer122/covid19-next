//
// 이 파일은 JAXB(JavaTM Architecture for XML Binding) 참조 구현 2.3.1 버전을 통해 생성되었습니다. 
// <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a>를 참조하십시오. 
// 이 파일을 수정하면 소스 스키마를 재컴파일할 때 수정 사항이 손실됩니다. 
// 생성 날짜: 2021.08.18 시간 07:21:33 PM KST 
//


package com.covid19next.model.countryinfo;

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
 * <p>anonymous complex type에 대한 Java 클래스입니다.
 * 
 * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
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
 *                                       &lt;element name="basic" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                                       &lt;element name="continent" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                                       &lt;element name="countryEnName" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                                       &lt;element name="countryName" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                                       &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}unsignedShort"/&gt;
 *                                       &lt;element name="imgUrl" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
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
public class CountryResponse {

    @XmlElement(required = true)
    protected Header header;
    @XmlElement(required = true)
    protected Body body;

    /**
     * header 속성의 값을 가져옵니다.
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
     * header 속성의 값을 설정합니다.
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
     * body 속성의 값을 가져옵니다.
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
     * body 속성의 값을 설정합니다.
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
     * <p>anonymous complex type에 대한 Java 클래스입니다.
     * 
     * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
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
     *                             &lt;element name="basic" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
     *                             &lt;element name="continent" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
     *                             &lt;element name="countryEnName" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
     *                             &lt;element name="countryName" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
     *                             &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}unsignedShort"/&gt;
     *                             &lt;element name="imgUrl" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
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
         * items 속성의 값을 가져옵니다.
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
         * items 속성의 값을 설정합니다.
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
         * numOfRows 속성의 값을 가져옵니다.
         * 
         */
        public short getNumOfRows() {
            return numOfRows;
        }

        /**
         * numOfRows 속성의 값을 설정합니다.
         * 
         */
        public void setNumOfRows(short value) {
            this.numOfRows = value;
        }

        /**
         * pageNo 속성의 값을 가져옵니다.
         * 
         */
        public short getPageNo() {
            return pageNo;
        }

        /**
         * pageNo 속성의 값을 설정합니다.
         * 
         */
        public void setPageNo(short value) {
            this.pageNo = value;
        }

        /**
         * totalCount 속성의 값을 가져옵니다.
         * 
         */
        public short getTotalCount() {
            return totalCount;
        }

        /**
         * totalCount 속성의 값을 설정합니다.
         * 
         */
        public void setTotalCount(short value) {
            this.totalCount = value;
        }


        /**
         * <p>anonymous complex type에 대한 Java 클래스입니다.
         * 
         * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
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
         *                   &lt;element name="basic" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
         *                   &lt;element name="continent" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
         *                   &lt;element name="countryEnName" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
         *                   &lt;element name="countryName" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
         *                   &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}unsignedShort"/&gt;
         *                   &lt;element name="imgUrl" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
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
             * <p>anonymous complex type에 대한 Java 클래스입니다.
             * 
             * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
             * 
             * <pre>
             * &lt;complexType&gt;
             *   &lt;complexContent&gt;
             *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
             *       &lt;sequence&gt;
             *         &lt;element name="basic" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
             *         &lt;element name="continent" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
             *         &lt;element name="countryEnName" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
             *         &lt;element name="countryName" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
             *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}unsignedShort"/&gt;
             *         &lt;element name="imgUrl" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
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
                "basic",
                "continent",
                "countryEnName",
                "countryName",
                "id",
                "imgUrl",
                "wrtDt"
            })
            public static class Item {

                @XmlElement(required = true)
                protected String basic;
                @XmlElement(required = true)
                protected String continent;
                @XmlElement(required = true)
                protected String countryEnName;
                @XmlElement(required = true)
                protected String countryName;
                @XmlSchemaType(name = "unsignedShort")
                protected int id;
                @XmlElement(required = true)
                protected String imgUrl;
                @XmlElement(required = true)
                @XmlSchemaType(name = "date")
                protected XMLGregorianCalendar wrtDt;

                /**
                 * basic 속성의 값을 가져옵니다.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getBasic() {
                    return basic;
                }

                /**
                 * basic 속성의 값을 설정합니다.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setBasic(String value) {
                    this.basic = value;
                }

                /**
                 * continent 속성의 값을 가져옵니다.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getContinent() {
                    return continent;
                }

                /**
                 * continent 속성의 값을 설정합니다.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setContinent(String value) {
                    this.continent = value;
                }

                /**
                 * countryEnName 속성의 값을 가져옵니다.
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
                 * countryEnName 속성의 값을 설정합니다.
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
                 * countryName 속성의 값을 가져옵니다.
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
                 * countryName 속성의 값을 설정합니다.
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
                 * id 속성의 값을 가져옵니다.
                 * 
                 */
                public int getId() {
                    return id;
                }

                /**
                 * id 속성의 값을 설정합니다.
                 * 
                 */
                public void setId(int value) {
                    this.id = value;
                }

                /**
                 * imgUrl 속성의 값을 가져옵니다.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getImgUrl() {
                    return imgUrl;
                }

                /**
                 * imgUrl 속성의 값을 설정합니다.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setImgUrl(String value) {
                    this.imgUrl = value;
                }

                /**
                 * wrtDt 속성의 값을 가져옵니다.
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
                 * wrtDt 속성의 값을 설정합니다.
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
     * <p>anonymous complex type에 대한 Java 클래스입니다.
     * 
     * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
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
         * resultCode 속성의 값을 가져옵니다.
         * 
         */
        public short getResultCode() {
            return resultCode;
        }

        /**
         * resultCode 속성의 값을 설정합니다.
         * 
         */
        public void setResultCode(short value) {
            this.resultCode = value;
        }

        /**
         * resultMsg 속성의 값을 가져옵니다.
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
         * resultMsg 속성의 값을 설정합니다.
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
