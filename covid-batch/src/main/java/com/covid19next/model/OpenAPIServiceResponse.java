//
// �� ������ JAXB(JavaTM Architecture for XML Binding) ���� ���� 2.3.1 ������ ���� �����Ǿ����ϴ�. 
// <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a>�� �����Ͻʽÿ�. 
// �� ������ �����ϸ� �ҽ� ��Ű���� ���������� �� ���� ������ �սǵ˴ϴ�. 
// ���� ��¥: 2021.08.13 �ð� 04:34:39 PM KST 
//


package com.covid19next.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


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
 *         &lt;element name="cmmMsgHeader"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="errMsg" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                   &lt;element name="returnAuthMsg" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                   &lt;element name="returnReasonCode" type="{http://www.w3.org/2001/XMLSchema}unsignedByte"/&gt;
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
    "cmmMsgHeader"
})
@XmlRootElement(name = "OpenAPI_ServiceResponse")
public class OpenAPIServiceResponse {

    @XmlElement(required = true)
    protected CmmMsgHeader cmmMsgHeader;

    /**
     * cmmMsgHeader �Ӽ��� ���� �����ɴϴ�.
     * 
     * @return
     *     possible object is
     *     {@link CmmMsgHeader }
     *     
     */
    public CmmMsgHeader getCmmMsgHeader() {
        return cmmMsgHeader;
    }

    /**
     * cmmMsgHeader �Ӽ��� ���� �����մϴ�.
     * 
     * @param value
     *     allowed object is
     *     {@link CmmMsgHeader }
     *     
     */
    public void setCmmMsgHeader(CmmMsgHeader value) {
        this.cmmMsgHeader = value;
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
     *         &lt;element name="errMsg" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
     *         &lt;element name="returnAuthMsg" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
     *         &lt;element name="returnReasonCode" type="{http://www.w3.org/2001/XMLSchema}unsignedByte"/&gt;
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
        "errMsg",
        "returnAuthMsg",
        "returnReasonCode"
    })
    public static class CmmMsgHeader {

        @XmlElement(required = true)
        protected String errMsg;
        @XmlElement(required = true)
        protected String returnAuthMsg;
        @XmlSchemaType(name = "unsignedByte")
        protected short returnReasonCode;

        /**
         * errMsg �Ӽ��� ���� �����ɴϴ�.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getErrMsg() {
            return errMsg;
        }

        /**
         * errMsg �Ӽ��� ���� �����մϴ�.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setErrMsg(String value) {
            this.errMsg = value;
        }

        /**
         * returnAuthMsg �Ӽ��� ���� �����ɴϴ�.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getReturnAuthMsg() {
            return returnAuthMsg;
        }

        /**
         * returnAuthMsg �Ӽ��� ���� �����մϴ�.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setReturnAuthMsg(String value) {
            this.returnAuthMsg = value;
        }

        /**
         * returnReasonCode �Ӽ��� ���� �����ɴϴ�.
         * 
         */
        public short getReturnReasonCode() {
            return returnReasonCode;
        }

        /**
         * returnReasonCode �Ӽ��� ���� �����մϴ�.
         * 
         */
        public void setReturnReasonCode(short value) {
            this.returnReasonCode = value;
        }

    }

}
