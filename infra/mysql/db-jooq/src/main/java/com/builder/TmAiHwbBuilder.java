package com.builder;

/**
 * TmAiHwbBuilder 클래스
 *
 * <p>설명:
 * <p>
 * 작성자: akfur
 * 작성일: 2025-09-14
 */

import com.example.jooq.generated.tables.pojos.TmAiHwbPojo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class TmAiHwbBuilder implements Serializable {
    private Long id;
    private String orderNo;
    private LocalDateTime orderDt;
    private Long agentId;
    private String mappingNo;
    private String hwbNo;
    private String hsn;
    private String deliverySt;
    private String deliveryCode;
    private LocalDateTime deliverySdt;
    private LocalDateTime deliveryEdt;
    private String deliveryTel;
    private String deliveryZip;
    private Long mwbId;
    private String cargoType;
    private String hwbScd;
    private String hwbEcd;
    private String assignmentCode;
    private String assignmentWh;
    private String goodsNames;
    private String goodsCode;
    private String hsCode;
    private String shipperCode;
    private String shipperNameExp;
    private String shipperNameImp;
    private String shipperNameEng;
    private String shipperZip;
    private String shipperAddressExp;
    private String shipperAddressImp;
    private String shipperAddressEng;
    private String shipperPlace;
    private String shipperStreet;
    private String shipperState;
    private String shipperCountry;
    private String shipperTel;
    private String shipperCity;
    private String shipperNo;
    private String consigneeType;
    private String consigneeCode;
    private String consigneeNameExp;
    private String consigneeNameImp;
    private String consigneeNameEng;
    private String consigneeZip;
    private String consigneeAddressExp;
    private String consigneeAddressImp;
    private String consigneeAddressEng;
    private String consigneePlace;
    private String consigneeStreet;
    private String consigneeState;
    private String consigneeCountry;
    private String consigneeCel;
    private String consigneeTel;
    private String consigneeCity;
    private String clearanceForce;
    private String clearanceType;
    private Integer qty;
    private Integer qtyTotal;
    private String qtyUnit;
    private BigDecimal weight;
    private String weightUnit;
    private BigDecimal priceUsd;
    private String checkReq;
    private String checkLog;
    private String customsCheck;
    private String customsName;
    private String customsResult;
    private String tradeType;
    private String useType;
    private String siteHttpUrl;
    private String changeDocNo;
    private String changeAddress;
    private String changeReason;
    private String changeGubun;
    private LocalDateTime changeDt;
    private String changeDelivery;
    private LocalDateTime changeDeliveryDt;
    private LocalDateTime changeRecvAt;
    private String kctdiSendNo;
    private String kctdiDel;
    private String kctdiIo;
    private String blPrint;
    private String clearanceResult;
    private LocalDate clearanceResultAt;
    private String createdBy;
    private LocalDateTime createdAt;
    private String updatedBy;
    private LocalDateTime updatedAt;
    private String printData;
    private String cancelReason;
    private String hwbRemark;
    private String docError;
    private String kakaoStatus;
    private Integer kakaoSendCnt;
    private String managementSt;
    private String managementMemo;
    private String managementDiv;
    private String changeHwbIdx;
    private String pccError;
    private Long version;
    private String errCode;
    private String multiNo;
    private String pccErmsg;
    private String location;
    private String commercetype;
    private String agency;
    private String previousConsigneeAddressImp;
    private String deliveryError;
    private String multiType;

    // ==================== Builder 메서드 ====================

    public static TmAiHwbBuilder Builder() {
        return new TmAiHwbBuilder();
    }

    public TmAiHwbBuilder id(Long id) { this.id = id; return this; }
    public TmAiHwbBuilder orderNo(String orderNo) { this.orderNo = orderNo; return this; }
    public TmAiHwbBuilder orderDt(LocalDateTime orderDt) { this.orderDt = orderDt; return this; }
    public TmAiHwbBuilder agentId(Long agentId) { this.agentId = agentId; return this; }
    public TmAiHwbBuilder mappingNo(String mappingNo) { this.mappingNo = mappingNo; return this; }
    public TmAiHwbBuilder hwbNo(String hwbNo) { this.hwbNo = hwbNo; return this; }
    public TmAiHwbBuilder hsn(String hsn) { this.hsn = hsn; return this; }
    public TmAiHwbBuilder deliverySt(String deliverySt) { this.deliverySt = deliverySt; return this; }
    public TmAiHwbBuilder deliveryCode(String deliveryCode) { this.deliveryCode = deliveryCode; return this; }
    public TmAiHwbBuilder deliverySdt(LocalDateTime deliverySdt) { this.deliverySdt = deliverySdt; return this; }
    public TmAiHwbBuilder deliveryEdt(LocalDateTime deliveryEdt) { this.deliveryEdt = deliveryEdt; return this; }
    public TmAiHwbBuilder deliveryTel(String deliveryTel) { this.deliveryTel = deliveryTel; return this; }
    public TmAiHwbBuilder deliveryZip(String deliveryZip) { this.deliveryZip = deliveryZip; return this; }
    public TmAiHwbBuilder mwbId(Long mwbId) { this.mwbId = mwbId; return this; }
    public TmAiHwbBuilder cargoType(String cargoType) { this.cargoType = cargoType; return this; }
    public TmAiHwbBuilder hwbScd(String hwbScd) { this.hwbScd = hwbScd; return this; }
    public TmAiHwbBuilder hwbEcd(String hwbEcd) { this.hwbEcd = hwbEcd; return this; }
    public TmAiHwbBuilder assignmentCode(String assignmentCode) { this.assignmentCode = assignmentCode; return this; }
    public TmAiHwbBuilder assignmentWh(String assignmentWh) { this.assignmentWh = assignmentWh; return this; }
    public TmAiHwbBuilder goodsNames(String goodsNames) { this.goodsNames = goodsNames; return this; }
    public TmAiHwbBuilder goodsCode(String goodsCode) { this.goodsCode = goodsCode; return this; }
    public TmAiHwbBuilder hsCode(String hsCode) { this.hsCode = hsCode; return this; }
    public TmAiHwbBuilder shipperCode(String shipperCode) { this.shipperCode = shipperCode; return this; }
    public TmAiHwbBuilder shipperNameExp(String shipperNameExp) { this.shipperNameExp = shipperNameExp; return this; }
    public TmAiHwbBuilder shipperNameImp(String shipperNameImp) { this.shipperNameImp = shipperNameImp; return this; }
    public TmAiHwbBuilder shipperNameEng(String shipperNameEng) { this.shipperNameEng = shipperNameEng; return this; }
    public TmAiHwbBuilder shipperZip(String shipperZip) { this.shipperZip = shipperZip; return this; }
    public TmAiHwbBuilder shipperAddressExp(String shipperAddressExp) { this.shipperAddressExp = shipperAddressExp; return this; }
    public TmAiHwbBuilder shipperAddressImp(String shipperAddressImp) { this.shipperAddressImp = shipperAddressImp; return this; }
    public TmAiHwbBuilder shipperAddressEng(String shipperAddressEng) { this.shipperAddressEng = shipperAddressEng; return this; }
    public TmAiHwbBuilder shipperPlace(String shipperPlace) { this.shipperPlace = shipperPlace; return this; }
    public TmAiHwbBuilder shipperStreet(String shipperStreet) { this.shipperStreet = shipperStreet; return this; }
    public TmAiHwbBuilder shipperState(String shipperState) { this.shipperState = shipperState; return this; }
    public TmAiHwbBuilder shipperCountry(String shipperCountry) { this.shipperCountry = shipperCountry; return this; }
    public TmAiHwbBuilder shipperTel(String shipperTel) { this.shipperTel = shipperTel; return this; }
    public TmAiHwbBuilder shipperCity(String shipperCity) { this.shipperCity = shipperCity; return this; }
    public TmAiHwbBuilder shipperNo(String shipperNo) { this.shipperNo = shipperNo; return this; }
    public TmAiHwbBuilder consigneeType(String consigneeType) { this.consigneeType = consigneeType; return this; }
    public TmAiHwbBuilder consigneeCode(String consigneeCode) { this.consigneeCode = consigneeCode; return this; }
    public TmAiHwbBuilder consigneeNameExp(String consigneeNameExp) { this.consigneeNameExp = consigneeNameExp; return this; }
    public TmAiHwbBuilder consigneeNameImp(String consigneeNameImp) { this.consigneeNameImp = consigneeNameImp; return this; }
    public TmAiHwbBuilder consigneeNameEng(String consigneeNameEng) { this.consigneeNameEng = consigneeNameEng; return this; }
    public TmAiHwbBuilder consigneeZip(String consigneeZip) { this.consigneeZip = consigneeZip; return this; }
    public TmAiHwbBuilder consigneeAddressExp(String consigneeAddressExp) { this.consigneeAddressExp = consigneeAddressExp; return this; }
    public TmAiHwbBuilder consigneeAddressImp(String consigneeAddressImp) { this.consigneeAddressImp = consigneeAddressImp; return this; }
    public TmAiHwbBuilder consigneeAddressEng(String consigneeAddressEng) { this.consigneeAddressEng = consigneeAddressEng; return this; }
    public TmAiHwbBuilder consigneePlace(String consigneePlace) { this.consigneePlace = consigneePlace; return this; }
    public TmAiHwbBuilder consigneeStreet(String consigneeStreet) { this.consigneeStreet = consigneeStreet; return this; }
    public TmAiHwbBuilder consigneeState(String consigneeState) { this.consigneeState = consigneeState; return this; }
    public TmAiHwbBuilder consigneeCountry(String consigneeCountry) { this.consigneeCountry = consigneeCountry; return this; }
    public TmAiHwbBuilder consigneeCel(String consigneeCel) { this.consigneeCel = consigneeCel; return this; }
    public TmAiHwbBuilder consigneeTel(String consigneeTel) { this.consigneeTel = consigneeTel; return this; }
    public TmAiHwbBuilder consigneeCity(String consigneeCity) { this.consigneeCity = consigneeCity; return this; }
    public TmAiHwbBuilder clearanceForce(String clearanceForce) { this.clearanceForce = clearanceForce; return this; }
    public TmAiHwbBuilder clearanceType(String clearanceType) { this.clearanceType = clearanceType; return this; }
    public TmAiHwbBuilder qty(Integer qty) { this.qty = qty; return this; }
    public TmAiHwbBuilder qtyTotal(Integer qtyTotal) { this.qtyTotal = qtyTotal; return this; }
    public TmAiHwbBuilder qtyUnit(String qtyUnit) { this.qtyUnit = qtyUnit; return this; }
    public TmAiHwbBuilder weight(BigDecimal weight) { this.weight = weight; return this; }
    public TmAiHwbBuilder weightUnit(String weightUnit) { this.weightUnit = weightUnit; return this; }
    public TmAiHwbBuilder priceUsd(BigDecimal priceUsd) { this.priceUsd = priceUsd; return this; }
    public TmAiHwbBuilder checkReq(String checkReq) { this.checkReq = checkReq; return this; }
    public TmAiHwbBuilder checkLog(String checkLog) { this.checkLog = checkLog; return this; }
    public TmAiHwbBuilder customsCheck(String customsCheck) { this.customsCheck = customsCheck; return this; }
    public TmAiHwbBuilder customsName(String customsName) { this.customsName = customsName; return this; }
    public TmAiHwbBuilder customsResult(String customsResult) { this.customsResult = customsResult; return this; }
    public TmAiHwbBuilder tradeType(String tradeType) { this.tradeType = tradeType; return this; }
    public TmAiHwbBuilder useType(String useType) { this.useType = useType; return this; }
    public TmAiHwbBuilder siteHttpUrl(String siteHttpUrl) { this.siteHttpUrl = siteHttpUrl; return this; }
    public TmAiHwbBuilder changeDocNo(String changeDocNo) { this.changeDocNo = changeDocNo; return this; }
    public TmAiHwbBuilder changeAddress(String changeAddress) { this.changeAddress = changeAddress; return this; }
    public TmAiHwbBuilder changeReason(String changeReason) { this.changeReason = changeReason; return this; }
    public TmAiHwbBuilder changeGubun(String changeGubun) { this.changeGubun = changeGubun; return this; }
    public TmAiHwbBuilder changeDt(LocalDateTime changeDt) { this.changeDt = changeDt; return this; }
    public TmAiHwbBuilder changeDelivery(String changeDelivery) { this.changeDelivery = changeDelivery; return this; }
    public TmAiHwbBuilder changeDeliveryDt(LocalDateTime changeDeliveryDt) { this.changeDeliveryDt = changeDeliveryDt; return this; }
    public TmAiHwbBuilder changeRecvAt(LocalDateTime changeRecvAt) { this.changeRecvAt = changeRecvAt; return this; }
    public TmAiHwbBuilder kctdiSendNo(String kctdiSendNo) { this.kctdiSendNo = kctdiSendNo; return this; }
    public TmAiHwbBuilder kctdiDel(String kctdiDel) { this.kctdiDel = kctdiDel; return this; }
    public TmAiHwbBuilder kctdiIo(String kctdiIo) { this.kctdiIo = kctdiIo; return this; }
    public TmAiHwbBuilder blPrint(String blPrint) { this.blPrint = blPrint; return this; }
    public TmAiHwbBuilder clearanceResult(String clearanceResult) { this.clearanceResult = clearanceResult; return this; }
    public TmAiHwbBuilder clearanceResultAt(LocalDate clearanceResultAt) { this.clearanceResultAt = clearanceResultAt; return this; }
    public TmAiHwbBuilder createdBy(String createdBy) { this.createdBy = createdBy; return this; }
    public TmAiHwbBuilder createdAt(LocalDateTime createdAt) { this.createdAt = createdAt; return this; }
    public TmAiHwbBuilder updatedBy(String updatedBy) { this.updatedBy = updatedBy; return this; }
    public TmAiHwbBuilder updatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; return this; }
    public TmAiHwbBuilder printData(String printData) { this.printData = printData; return this; }
    public TmAiHwbBuilder cancelReason(String cancelReason) { this.cancelReason = cancelReason; return this; }
    public TmAiHwbBuilder hwbRemark(String hwbRemark) { this.hwbRemark = hwbRemark; return this; }
    public TmAiHwbBuilder docError(String docError) { this.docError = docError; return this; }
    public TmAiHwbBuilder kakaoStatus(String kakaoStatus) { this.kakaoStatus = kakaoStatus; return this; }
    public TmAiHwbBuilder kakaoSendCnt(Integer kakaoSendCnt) { this.kakaoSendCnt = kakaoSendCnt; return this; }
    public TmAiHwbBuilder managementSt(String managementSt) { this.managementSt = managementSt; return this; }
    public TmAiHwbBuilder managementMemo(String managementMemo) { this.managementMemo = managementMemo; return this; }
    public TmAiHwbBuilder managementDiv(String managementDiv) { this.managementDiv = managementDiv; return this; }
    public TmAiHwbBuilder changeHwbIdx(String changeHwbIdx) { this.changeHwbIdx = changeHwbIdx; return this; }
    public TmAiHwbBuilder pccError(String pccError) { this.pccError = pccError; return this; }
    public TmAiHwbBuilder version(Long version) { this.version = version; return this; }
    public TmAiHwbBuilder errCode(String errCode) { this.errCode = errCode; return this; }
    public TmAiHwbBuilder multiNo(String multiNo) { this.multiNo = multiNo; return this; }
    public TmAiHwbBuilder pccErmsg(String pccErmsg) { this.pccErmsg = pccErmsg; return this; }
    public TmAiHwbBuilder location(String location) { this.location = location; return this; }
    public TmAiHwbBuilder commercetype(String commercetype) { this.commercetype = commercetype; return this; }
    public TmAiHwbBuilder agency(String agency) { this.agency = agency; return this; }
    public TmAiHwbBuilder previousConsigneeAddressImp(String previousConsigneeAddressImp) { this.previousConsigneeAddressImp = previousConsigneeAddressImp; return this; }
    public TmAiHwbBuilder deliveryError(String deliveryError) { this.deliveryError = deliveryError; return this; }
    public TmAiHwbBuilder multiType(String multiType) { this.multiType = multiType; return this; }

    // ==================== build() ====================

    public TmAiHwbPojo build() {
        /*
        * TODO Builder패턴이라 null값이 들어갈 수 있음 build시 필수 값은 여기서 에러처리
        * */
        return new TmAiHwbPojo(
                id, orderNo, orderDt, agentId, mappingNo, hwbNo, hsn, deliverySt, deliveryCode,
                deliverySdt, deliveryEdt, deliveryTel, deliveryZip, mwbId, cargoType, hwbScd, hwbEcd,
                assignmentCode, assignmentWh, goodsNames, goodsCode, hsCode, shipperCode, shipperNameExp,
                shipperNameImp, shipperNameEng, shipperZip, shipperAddressExp, shipperAddressImp, shipperAddressEng,
                shipperPlace, shipperStreet, shipperState, shipperCountry, shipperTel, shipperCity, shipperNo,
                consigneeType, consigneeCode, consigneeNameExp, consigneeNameImp, consigneeNameEng, consigneeZip,
                consigneeAddressExp, consigneeAddressImp, consigneeAddressEng, consigneePlace, consigneeStreet,
                consigneeState, consigneeCountry, consigneeCel, consigneeTel, consigneeCity, clearanceForce,
                clearanceType, qty, qtyTotal, qtyUnit, weight, weightUnit, priceUsd, checkReq, checkLog,
                customsCheck, customsName, customsResult, tradeType, useType, siteHttpUrl, changeDocNo, changeAddress,
                changeReason, changeGubun, changeDt, changeDelivery, changeDeliveryDt, changeRecvAt, kctdiSendNo,
                kctdiDel, kctdiIo, blPrint, clearanceResult, clearanceResultAt, createdBy, createdAt, updatedBy,
                updatedAt, printData, cancelReason, hwbRemark, docError, kakaoStatus, kakaoSendCnt, managementSt,
                managementMemo, managementDiv, changeHwbIdx, pccError, version, errCode, multiNo, pccErmsg,
                location, commercetype, agency, previousConsigneeAddressImp, deliveryError, multiType
        );
    }
}
