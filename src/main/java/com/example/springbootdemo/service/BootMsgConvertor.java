package com.example.springbootdemo.service;

import java.util.Iterator;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.springbootdemo.config.CommonConfig;
import com.example.springbootdemo.pojo.BaseMessage;
import com.example.springbootdemo.pojo.BootMessage;
import com.example.springbootdemo.pojo.PeriodicMessage;

import lombok.extern.slf4j.Slf4j;

/**
 * @Project: spring-boot-demo
 * @Author : haihuab
 * @Date : 2023/1/12 16:58
 * @Description:
 */

@Slf4j
@Service
@Qualifier("BootMsgConvertor")
public class BootMsgConvertor extends CsvConvertor{
    @Override
    public String convertToCsv(BaseMessage baseMessage) {
        Objects.requireNonNull(baseMessage);
        BootMessage bootMessage = (BootMessage)baseMessage;

        StringBuilder sb = new StringBuilder();
        appendCommonFields(bootMessage,sb);
        sb.append(bootMessage.getDeviceInfo().getManufacturer()).append(CommonConfig.TempFieldSeparator);
        sb.append(bootMessage.getDeviceInfo().getCpu()).append(CommonConfig.TempFieldSeparator);
        sb.append(bootMessage.getDeviceInfo().getHardwareVersion()).append(CommonConfig.TempFieldSeparator);
        sb.append(bootMessage.getDeviceInfo().getFirmwareVersion()).append(CommonConfig.TempFieldSeparator);
        sb.append(bootMessage.getDeviceInfo().getModel()).append(CommonConfig.TempFieldSeparator);
        sb.append(bootMessage.getDeviceInfo().getMac()).append(CommonConfig.TempFieldSeparator);
        sb.append(CommonConfig.TempFieldSeparator);
        sb.append(CommonConfig.TempFieldSeparator);
        sb.append(CommonConfig.TempFieldSeparator);
        sb.append(CommonConfig.TempFieldSeparator);
        sb.append(CommonConfig.TempFieldSeparator);
        sb.append(CommonConfig.TempFieldSeparator);
        sb.append(CommonConfig.TempFieldSeparator);
        sb.append(bootMessage.getDeviceInfo().getNfcSupport()).append(CommonConfig.TempFieldSeparator);
        sb.append(bootMessage.getDeviceInfo().getFlashSize()).append(CommonConfig.TempFieldSeparator);
        sb.append(bootMessage.getDeviceInfo().getRam_size()).append(CommonConfig.TempFieldSeparator);
        sb.append(bootMessage.getDpiVersionInfo().getVersion()).append(CommonConfig.TempFieldSeparator);
        sb.append(formatBootAndSampleTime(bootMessage.getDeviceStatus().getBootTime())).append(CommonConfig.TempFieldSeparator);
        sb.append(bootMessage.getDeviceStatus().getRuningTime()).append(CommonConfig.TempFieldSeparator);
        sb.append(bootMessage.getDeviceStatus().getCPU()).append(CommonConfig.TempFieldSeparator);
        sb.append(bootMessage.getDeviceStatus().getRAM()).append(CommonConfig.TempFieldSeparator);
        sb.append(bootMessage.getDeviceStatus().getLanIP()).append(CommonConfig.TempFieldSeparator);
        sb.append(bootMessage.getDeviceStatus().getWanIP()).append(CommonConfig.TempFieldSeparator);
        sb.append(bootMessage.getDeviceStatus().getLan1ConnectStatus()).append(CommonConfig.TempFieldSeparator);
        sb.append(bootMessage.getDeviceStatus().getLan2ConnectStatus()).append(CommonConfig.TempFieldSeparator);
        sb.append(bootMessage.getDeviceStatus().getLan3ConnectStatus()).append(CommonConfig.TempFieldSeparator);
        sb.append(bootMessage.getDeviceStatus().getLan4ConnectStatus()).append(CommonConfig.TempFieldSeparator);
        sb.append(bootMessage.getDeviceStatus().getWAN()).append(CommonConfig.TempFieldSeparator);
        sb.append(bootMessage.getDeviceStatus().getWIFI()).append(CommonConfig.TempFieldSeparator);
        sb.append(bootMessage.getDeviceStatus().getPPPOEError()).append(CommonConfig.TempFieldSeparator);
        sb.append(bootMessage.getDeviceStatus().getPPPOEStatus()).append(CommonConfig.TempFieldSeparator);
        sb.append(bootMessage.getPonInfo().getPONTXPower()).append(CommonConfig.TempFieldSeparator);
        sb.append(bootMessage.getPonInfo().getPONRXPower()).append(CommonConfig.TempFieldSeparator);
        sb.append(bootMessage.getPotsInfo().getPotsIndex()).append(CommonConfig.TempFieldSeparator);
        sb.append(bootMessage.getPotsInfo().getPotsPhoneNumber()).append(CommonConfig.TempFieldSeparator);
        sb.append(bootMessage.getPotsInfo().getPotsStatus()).append(CommonConfig.TempFieldSeparator);

        sb.append(bootMessage.getWLANNeighbor().getNumber()).append(CommonConfig.TempFieldSeparator);
        if (bootMessage.getWLANNeighbor() != null && bootMessage.getWLANNeighbor().getRadioInfo() != null
                && bootMessage.getWLANNeighbor().getRadioInfo().size() > 0) {
            sb.append(bootMessage.getWLANNeighbor().getRadioInfo().size()).append(CommonConfig.TempFieldSeparator);
            for (Iterator<PeriodicMessage.RadioInfo> iter = bootMessage.getWLANNeighbor().getRadioInfo().iterator(); iter.hasNext(); ) {
                PeriodicMessage.RadioInfo radioInfo = iter.next();
                sb.append(radioInfo.getRadioType()).append(CommonConfig.TempFieldSeparator);
                sb.append(radioInfo.getSSIDName()).append(CommonConfig.TempFieldSeparator);
                sb.append(radioInfo.getMac()).append(CommonConfig.TempFieldSeparator);
                sb.append(radioInfo.getChannel()).append(CommonConfig.TempFieldSeparator);
                sb.append(radioInfo.getWLANRadioPower());

                if (iter.hasNext()) {
                    sb.append(CommonConfig.TempFieldSeparator);
                }
            }

        }
        sb.append(CommonConfig.TempFieldSeparator);

        sb.append(bootMessage.getSubDeviceInfo().getSubDeviceNumber()).append(CommonConfig.TempFieldSeparator);
        if (bootMessage.getSubDeviceInfo() != null && bootMessage.getSubDeviceInfo().getDeviceInfo() != null
                && bootMessage.getSubDeviceInfo().getDeviceInfo().size() > 0) {
            sb.append(bootMessage.getSubDeviceInfo().getDeviceInfo().size()).append(CommonConfig.TempFieldSeparator);
            for (Iterator<PeriodicMessage.DeviceInfoOfSubDevice> iter = bootMessage.getSubDeviceInfo().getDeviceInfo().iterator(); iter.hasNext(); ) {
                PeriodicMessage.DeviceInfoOfSubDevice deviceInfoOfSubDevice = iter.next();
                sb.append(deviceInfoOfSubDevice.getDeviceType()).append(CommonConfig.TempFieldSeparator);
                sb.append(deviceInfoOfSubDevice.getDeviceName()).append(CommonConfig.TempFieldSeparator);
                sb.append(deviceInfoOfSubDevice.getManufacture()).append(CommonConfig.TempFieldSeparator);
                sb.append(deviceInfoOfSubDevice.getModel()).append(CommonConfig.TempFieldSeparator);
                sb.append(deviceInfoOfSubDevice.getMac()).append(CommonConfig.TempFieldSeparator);
                sb.append(deviceInfoOfSubDevice.getWLANRadioType()).append(CommonConfig.TempFieldSeparator);
                sb.append(deviceInfoOfSubDevice.getWLANRadioPower());

                if (iter.hasNext()) {
                    sb.append(CommonConfig.TempFieldSeparator);
                }

            }
        }
        sb.append(CommonConfig.TempFieldSeparator);

        sb.append(bootMessage.getEventType().getEventCode()).append(CommonConfig.TempFieldSeparator);
        sb.append(bootMessage.getEventType().getSubEvent()).append(CommonConfig.TempFieldSeparator);
        sb.append(bootMessage.getTimeOffset()).append(CommonConfig.TempFieldSeparator);

        if (bootMessage.getDeviceInfo() != null && bootMessage.getDeviceInfo().getWifiInfoList() != null
                && bootMessage.getDeviceInfo().getWifiInfoList().size() > 0) {
            sb.append(bootMessage.getDeviceInfo().getWifiInfoList().size()).append(CommonConfig.TempFieldSeparator);
            for (Iterator<PeriodicMessage.WifiInfo> iter = bootMessage.getDeviceInfo().getWifiInfoList().iterator(); iter.hasNext(); ) {
                PeriodicMessage.WifiInfo wifiInfo = iter.next();
                sb.append(wifiInfo.getSSID()).append(CommonConfig.TempFieldSeparator);
                sb.append(wifiInfo.getSSIDname()).append(CommonConfig.TempFieldSeparator);
                sb.append(wifiInfo.getSSIDMAC()).append(CommonConfig.TempFieldSeparator);
                sb.append(wifiInfo.getSSIDEnable()).append(CommonConfig.TempFieldSeparator);
                sb.append(wifiInfo.getChannel()).append(CommonConfig.TempFieldSeparator);
                sb.append(wifiInfo.getSSIDAdvertisement()).append(CommonConfig.TempFieldSeparator);
                sb.append(wifiInfo.getSSIDStandard()).append(CommonConfig.TempFieldSeparator);
                sb.append(wifiInfo.getSSIDEncryptionMode());

                if (iter.hasNext()) {
                    sb.append(CommonConfig.TempFieldSeparator);
                }
            }
        }
        sb.append(CommonConfig.TempFieldSeparator);

        sb.append(bootMessage.getDpiVersionInfo().getInterfaceVersion());

        return doFinallyProcessing(sb);
    }
}
