package com.example.springbootdemo.service;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Objects;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.springbootdemo.config.CommonConfig;
import com.example.springbootdemo.pojo.BaseMessage;
import com.example.springbootdemo.pojo.PeriodicMessage;

import lombok.extern.slf4j.Slf4j;

/**
 * @Project: spring-boot-demo
 * @Author : haihuab
 * @Date : 2022/12/15 16:24
 * @Description:
 */

@Slf4j
@Service
@Qualifier("PeriodicMsgConvertor")
public class PeriodicMsgConvertor extends CsvConvertor{

    public String convertToCsv(BaseMessage baseMessage) {
        Objects.requireNonNull(baseMessage);
        PeriodicMessage periodicMessage = (PeriodicMessage)baseMessage;

        StringBuilder sb = new StringBuilder();
        appendCommonFields(periodicMessage,sb);
//        sb.append(formatEventTime(periodicMessage.getActualTime())).append(CommonConfig.TempFieldSeparator);
//        sb.append(commonConfig.getProtocolVersion()).append(CommonConfig.TempFieldSeparator);
//        sb.append(periodicMessage.getCityCode()).append(CommonConfig.TempFieldSeparator);
//        sb.append(commonConfig.getDpiProvider()).append(CommonConfig.TempFieldSeparator);
//        sb.append(periodicMessage.getDeviceInfo().getDeviceId()).append(CommonConfig.TempFieldSeparator);
        sb.append(formatBootAndSampleTime(periodicMessage.getDeviceStatus().getBootTime())).append(CommonConfig.TempFieldSeparator);
        sb.append(periodicMessage.getDeviceStatus().getRuningTime()).append(CommonConfig.TempFieldSeparator);
        sb.append(formatBootAndSampleTime(periodicMessage.getDeviceStatus().getSampleTime())).append(CommonConfig.TempFieldSeparator);
        sb.append(periodicMessage.getDeviceStatus().getCPU()).append(CommonConfig.TempFieldSeparator);
        sb.append(periodicMessage.getDeviceStatus().getRAM()).append(CommonConfig.TempFieldSeparator);
        sb.append(periodicMessage.getDeviceStatus().getLanIP()).append(CommonConfig.TempFieldSeparator);
        sb.append(periodicMessage.getDeviceStatus().getWanIP()).append(CommonConfig.TempFieldSeparator);
        sb.append(periodicMessage.getDeviceStatus().getLan1ConnectStatus()).append(CommonConfig.TempFieldSeparator);
        sb.append(periodicMessage.getDeviceStatus().getLan2ConnectStatus()).append(CommonConfig.TempFieldSeparator);
        sb.append(periodicMessage.getDeviceStatus().getLan3ConnectStatus()).append(CommonConfig.TempFieldSeparator);
        sb.append(periodicMessage.getDeviceStatus().getLan4ConnectStatus()).append(CommonConfig.TempFieldSeparator);
        sb.append(periodicMessage.getDeviceStatus().getWAN()).append(CommonConfig.TempFieldSeparator);
        sb.append(periodicMessage.getDeviceStatus().getWIFI()).append(CommonConfig.TempFieldSeparator);
        sb.append(periodicMessage.getDeviceStatus().getPPPOEError()).append(CommonConfig.TempFieldSeparator);
        sb.append(periodicMessage.getDeviceStatus().getPPPOEStatus()).append(CommonConfig.TempFieldSeparator);
        sb.append(periodicMessage.getWanTrafficData().getWanNumber()).append(CommonConfig.TempFieldSeparator);
        if (periodicMessage.getWanTrafficData() != null && periodicMessage.getWanTrafficData().getWanTrafficInfo() != null
                && periodicMessage.getWanTrafficData().getWanTrafficInfo().size() > 0) {
            sb.append(periodicMessage.getWanTrafficData().getWanTrafficInfo().size()).append(CommonConfig.TempFieldSeparator);

            for (Iterator<PeriodicMessage.WanTrafficInfo> iter = periodicMessage.getWanTrafficData().getWanTrafficInfo().iterator(); iter.hasNext(); ) {
                PeriodicMessage.WanTrafficInfo wanTrafficInfo = iter.next();
                sb.append(wanTrafficInfo.getWanIndex()).append(CommonConfig.TempFieldSeparator);
                sb.append(wanTrafficInfo.getWanName()).append(CommonConfig.TempFieldSeparator);
                sb.append(wanTrafficInfo.getAverTxRate()).append(CommonConfig.TempFieldSeparator);
                sb.append(wanTrafficInfo.getAverRxRate()).append(CommonConfig.TempFieldSeparator);
                sb.append(wanTrafficInfo.getMaxTxRate()).append(CommonConfig.TempFieldSeparator);
                sb.append(wanTrafficInfo.getMaxRxRate()).append(CommonConfig.TempFieldSeparator);
                sb.append(wanTrafficInfo.getUpStaticstics()).append(CommonConfig.TempFieldSeparator);
                sb.append(wanTrafficInfo.getDownStaticstics());

                if (iter.hasNext()) {
                    sb.append(CommonConfig.TempFieldSeparator);
                }
            }
        }
        sb.append(CommonConfig.TempFieldSeparator);

        sb.append(periodicMessage.getSubDeviceInfo().getSubDeviceNumber()).append(CommonConfig.TempFieldSeparator);
        if (periodicMessage.getSubDeviceInfo() != null && periodicMessage.getSubDeviceInfo().getDeviceInfo() != null
                && periodicMessage.getSubDeviceInfo().getDeviceInfo().size() > 0) {
            sb.append(periodicMessage.getSubDeviceInfo().getDeviceInfo().size()).append(CommonConfig.TempFieldSeparator);
            for (Iterator<PeriodicMessage.DeviceInfoOfSubDevice> iter = periodicMessage.getSubDeviceInfo().getDeviceInfo().iterator(); iter.hasNext(); ) {
                PeriodicMessage.DeviceInfoOfSubDevice deviceInfoOfSubDevice = iter.next();
                sb.append(deviceInfoOfSubDevice.getDeviceType()).append(CommonConfig.TempFieldSeparator);
                sb.append(deviceInfoOfSubDevice.getDeviceName()).append(CommonConfig.TempFieldSeparator);
                sb.append(deviceInfoOfSubDevice.getManufacture()).append(CommonConfig.TempFieldSeparator);
                sb.append(deviceInfoOfSubDevice.getModel()).append(CommonConfig.TempFieldSeparator);
                sb.append(deviceInfoOfSubDevice.getMac()).append(CommonConfig.TempFieldSeparator);
                sb.append(deviceInfoOfSubDevice.getAverTxRate()).append(CommonConfig.TempFieldSeparator);
                sb.append(deviceInfoOfSubDevice.getAverRxRate()).append(CommonConfig.TempFieldSeparator);
                sb.append(deviceInfoOfSubDevice.getMaxTxRate()).append(CommonConfig.TempFieldSeparator);
                sb.append(deviceInfoOfSubDevice.getMaxRxRate()).append(CommonConfig.TempFieldSeparator);
                sb.append(deviceInfoOfSubDevice.getWLANRadioType()).append(CommonConfig.TempFieldSeparator);
                sb.append(deviceInfoOfSubDevice.getWLANRadioPower()).append(CommonConfig.TempFieldSeparator);
                sb.append(deviceInfoOfSubDevice.getUpStaticstics()).append(CommonConfig.TempFieldSeparator);
                sb.append(deviceInfoOfSubDevice.getDownStaticstics()).append(CommonConfig.TempFieldSeparator);
                sb.append(deviceInfoOfSubDevice.getIP()).append(CommonConfig.TempFieldSeparator);
                sb.append(deviceInfoOfSubDevice.getLanPort()).append(CommonConfig.TempFieldSeparator);
                sb.append(deviceInfoOfSubDevice.getLanNegBitRate()).append(CommonConfig.TempFieldSeparator);
                sb.append(deviceInfoOfSubDevice.getDuplexMode()).append(CommonConfig.TempFieldSeparator);
                sb.append(deviceInfoOfSubDevice.getWlanNegRxRate()).append(CommonConfig.TempFieldSeparator);
                sb.append(deviceInfoOfSubDevice.getWlanNegTxRate()).append(CommonConfig.TempFieldSeparator);
                sb.append(deviceInfoOfSubDevice.getIPv6Address()).append(CommonConfig.TempFieldSeparator);
                sb.append(deviceInfoOfSubDevice.getDhcpDeviceType());

                if (iter.hasNext()) {
                    sb.append(CommonConfig.TempFieldSeparator);
                }

            }
        }
        sb.append(CommonConfig.TempFieldSeparator);

        sb.append(periodicMessage.getPonInfo().getPONTXPower()).append(CommonConfig.TempFieldSeparator);
        sb.append(periodicMessage.getPonInfo().getPONRXPower()).append(CommonConfig.TempFieldSeparator);
        sb.append(periodicMessage.getPotsInfo().getPotsIndex()).append(CommonConfig.TempFieldSeparator);
        sb.append(periodicMessage.getPotsInfo().getPotsPhoneNumber()).append(CommonConfig.TempFieldSeparator);
        sb.append(periodicMessage.getPotsInfo().getPotsStatus()).append(CommonConfig.TempFieldSeparator);

        sb.append(periodicMessage.getWLANNeighbor().getNumber()).append(CommonConfig.TempFieldSeparator);
        if (periodicMessage.getWLANNeighbor() != null && periodicMessage.getWLANNeighbor().getRadioInfo() != null
                && periodicMessage.getWLANNeighbor().getRadioInfo().size() > 0) {
            sb.append(periodicMessage.getWLANNeighbor().getRadioInfo().size()).append(CommonConfig.TempFieldSeparator);
            for (Iterator<PeriodicMessage.RadioInfo> iter = periodicMessage.getWLANNeighbor().getRadioInfo().iterator(); iter.hasNext(); ) {
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

        sb.append(periodicMessage.getServiceData().getServiceNumber()).append(CommonConfig.TempFieldSeparator);
        if (periodicMessage.getServiceData() != null && periodicMessage.getServiceData().getServiceBasicInfo() != null
                && periodicMessage.getServiceData().getServiceBasicInfo().size() > 0) {
            sb.append(periodicMessage.getServiceData().getServiceBasicInfo().size()).append(CommonConfig.TempFieldSeparator);
            for (Iterator<PeriodicMessage.ServiceBasicInfo> iter = periodicMessage.getServiceData().getServiceBasicInfo().iterator(); iter.hasNext(); ) {
                PeriodicMessage.ServiceBasicInfo serviceBasicInfo = iter.next();
                sb.append(serviceBasicInfo.getMac()).append(CommonConfig.TempFieldSeparator);
                sb.append(serviceBasicInfo.getStartTime()).append(CommonConfig.TempFieldSeparator);
                sb.append(serviceBasicInfo.getRunningTime()).append(CommonConfig.TempFieldSeparator);
                sb.append(serviceBasicInfo.getUrl()).append(CommonConfig.TempFieldSeparator);
                sb.append(serviceBasicInfo.getDomain()).append(CommonConfig.TempFieldSeparator);
                sb.append(serviceBasicInfo.getProtocol()).append(CommonConfig.TempFieldSeparator);
                sb.append(serviceBasicInfo.getServiceType()).append(CommonConfig.TempFieldSeparator);
                sb.append(serviceBasicInfo.getAverTxRate()).append(CommonConfig.TempFieldSeparator);
                sb.append(serviceBasicInfo.getAverRxRate()).append(CommonConfig.TempFieldSeparator);
                sb.append(serviceBasicInfo.getMaxTxRate()).append(CommonConfig.TempFieldSeparator);
                sb.append(serviceBasicInfo.getMaxRxRate()).append(CommonConfig.TempFieldSeparator);
                sb.append(serviceBasicInfo.getUpStaticstics()).append(CommonConfig.TempFieldSeparator);
                sb.append(serviceBasicInfo.getDownStaticstics()).append(CommonConfig.TempFieldSeparator);
                sb.append(serviceBasicInfo.getTcpConnectInfo().getTcpConnectTimes()).append(CommonConfig.TempFieldSeparator);
                sb.append(serviceBasicInfo.getTcpConnectInfo().getTcpConnectSuccessTimes()).append(CommonConfig.TempFieldSeparator);
                sb.append(serviceBasicInfo.getTcpConnectInfo().getTcpConnectAvgTime()).append(CommonConfig.TempFieldSeparator);
                sb.append(serviceBasicInfo.getTcpConnectInfo().getTcpReconnectRate()).append(CommonConfig.TempFieldSeparator);
                sb.append(serviceBasicInfo.getHttpConnectInfo().getHttpResponesDelay()).append(CommonConfig.TempFieldSeparator);
                sb.append(StringUtils.replace(serviceBasicInfo.getHttpConnectInfo().getHttpRequestErrorList(), "|", ",")).append(CommonConfig.TempFieldSeparator);
                sb.append(serviceBasicInfo.getHttpConnectInfo().getHttpDownloadRate()).append(CommonConfig.TempFieldSeparator);
                sb.append(serviceBasicInfo.getHttpConnectInfo().getHttpRequestTimes()).append(CommonConfig.TempFieldSeparator);
                sb.append(serviceBasicInfo.getHttpConnectInfo().getHttpRequestFailTimes()).append(CommonConfig.TempFieldSeparator);
                sb.append(serviceBasicInfo.getDnsInfo().getDnsResponseTime()).append(CommonConfig.TempFieldSeparator);
                sb.append(serviceBasicInfo.getDnsInfo().getIpAddress()).append(CommonConfig.TempFieldSeparator);
                sb.append(serviceBasicInfo.getTcpConnectInfo().getTcpConnectAvgTime1()).append(CommonConfig.TempFieldSeparator);
                sb.append(serviceBasicInfo.getTcpConnectInfo().getTcpConnectAvgTime2()).append(CommonConfig.TempFieldSeparator);
                sb.append(serviceBasicInfo.getTcpConnectInfo().getTcpTTLInfo());

                if (iter.hasNext()) {
                    sb.append(CommonConfig.TempFieldSeparator);
                }
            }
        }
        sb.append(CommonConfig.TempFieldSeparator);

        sb.append(periodicMessage.getDeviceInfo().getManufacturer()).append(CommonConfig.TempFieldSeparator);
        sb.append(periodicMessage.getDeviceInfo().getModel()).append(CommonConfig.TempFieldSeparator);
        sb.append(periodicMessage.getEventType().getEventCode()).append(CommonConfig.TempFieldSeparator);
        sb.append(periodicMessage.getEventType().getSubEvent()).append(CommonConfig.TempFieldSeparator);
        sb.append(periodicMessage.getDeviceInfo().getCpu()).append(CommonConfig.TempFieldSeparator);
        sb.append(periodicMessage.getDeviceInfo().getHardwareVersion()).append(CommonConfig.TempFieldSeparator);
        sb.append(periodicMessage.getDeviceInfo().getFirmwareVersion()).append(CommonConfig.TempFieldSeparator);
        sb.append(periodicMessage.getDeviceInfo().getMac()).append(CommonConfig.TempFieldSeparator);

        if (periodicMessage.getDeviceInfo() != null && periodicMessage.getDeviceInfo().getWifiInfoList() != null
                && periodicMessage.getDeviceInfo().getWifiInfoList().size() > 0) {
            sb.append(periodicMessage.getDeviceInfo().getWifiInfoList().size()).append(CommonConfig.TempFieldSeparator);
            for (Iterator<PeriodicMessage.WifiInfo> iter = periodicMessage.getDeviceInfo().getWifiInfoList().iterator(); iter.hasNext(); ) {
                PeriodicMessage.WifiInfo wifiInfo = iter.next();
                sb.append(wifiInfo.getSSID()).append(CommonConfig.TempFieldSeparator);
                sb.append(wifiInfo.getSSIDname()).append(CommonConfig.TempFieldSeparator);
                sb.append(wifiInfo.getSSIDMAC()).append(CommonConfig.TempFieldSeparator);
                sb.append(wifiInfo.getSSIDEnable()).append(CommonConfig.TempFieldSeparator);
                sb.append(wifiInfo.getChannel()).append(CommonConfig.TempFieldSeparator);
                sb.append(wifiInfo.getSSIDAdvertisement()).append(CommonConfig.TempFieldSeparator);
                sb.append(wifiInfo.getSSIDStandard()).append(CommonConfig.TempFieldSeparator);
                sb.append(wifiInfo.getSSIDEncryptionMode()).append(CommonConfig.TempFieldSeparator);
                sb.append(wifiInfo.getTransmitPower()).append(CommonConfig.TempFieldSeparator);
                sb.append(wifiInfo.getNoiseLevel()).append(CommonConfig.TempFieldSeparator);
                sb.append(wifiInfo.getInterferencePercent());

                if (iter.hasNext()) {
                    sb.append(CommonConfig.TempFieldSeparator);
                }
            }
        }
        sb.append(CommonConfig.TempFieldSeparator);

        sb.append(periodicMessage.getDeviceInfo().getNfcSupport()).append(CommonConfig.TempFieldSeparator);
        sb.append(periodicMessage.getDeviceInfo().getFlashSize()).append(CommonConfig.TempFieldSeparator);
        sb.append(periodicMessage.getDeviceInfo().getRam_size()).append(CommonConfig.TempFieldSeparator);
        sb.append(periodicMessage.getDpiVersionInfo().getVersion()).append(CommonConfig.TempFieldSeparator);
        sb.append(periodicMessage.getDeviceStatus().getPPPOEUpTime()).append(CommonConfig.TempFieldSeparator);
        sb.append(periodicMessage.getDpiVersionInfo().getInterfaceVersion()).append(CommonConfig.TempFieldSeparator);

        if (periodicMessage.getDnsRequestInfo() != null && periodicMessage.getDnsRequestInfo().getDnsInfoList() != null
                && periodicMessage.getDnsRequestInfo().getDnsInfoList().size() > 0) {
            sb.append(periodicMessage.getDnsRequestInfo().getDnsInfoList().size()).append(CommonConfig.TempFieldSeparator);

            for (Iterator<PeriodicMessage.DnsInfoOfDnsRequestInfo> iter = periodicMessage.getDnsRequestInfo().getDnsInfoList().iterator();iter.hasNext();){
                PeriodicMessage.DnsInfoOfDnsRequestInfo dnsInfoOfDnsRequestInfo = iter.next();
                sb.append(dnsInfoOfDnsRequestInfo.getDomain()).append(CommonConfig.TempFieldSeparator);
                sb.append(Arrays.toString(dnsInfoOfDnsRequestInfo.getIpAddress())).append(CommonConfig.TempFieldSeparator);
                sb.append(dnsInfoOfDnsRequestInfo.getDnsAddress()).append(CommonConfig.TempFieldSeparator);
                sb.append(dnsInfoOfDnsRequestInfo.getDnsRequestTime()).append(CommonConfig.TempFieldSeparator);
                sb.append(dnsInfoOfDnsRequestInfo.getDnsResponseTime()).append(CommonConfig.TempFieldSeparator);
                sb.append(dnsInfoOfDnsRequestInfo.getErrorInfo());

                if (iter.hasNext()){
                    sb.append(CommonConfig.TempFieldSeparator);
                }
            }

        }
        sb.append(CommonConfig.TempFieldSeparator);

        sb.append(periodicMessage.getDeviceStatus().getUsername()).append(CommonConfig.TempFieldSeparator);
        sb.append(periodicMessage.getDeviceStatus().getLanIPV6()).append(CommonConfig.TempFieldSeparator);
        sb.append(periodicMessage.getDeviceStatus().getWanIPV6()).append(CommonConfig.TempFieldSeparator);
        sb.append(periodicMessage.getDeviceStatus().getMainChipTemperature());

        return doFinallyProcessing(sb);

    }


}
