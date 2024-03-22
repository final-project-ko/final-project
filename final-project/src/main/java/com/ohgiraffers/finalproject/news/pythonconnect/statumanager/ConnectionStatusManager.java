// Python 서버와의 연결 상태를 관리하는 컴포넌트
// 연결 상태를 확인하고, 상태 변경 시 이벤트를 발행하여 애플리케이션의 다른 부분에 알립니다.

package com.ohgiraffers.finalproject.news.pythonconnect.statumanager;

import com.ohgiraffers.finalproject.news.pythonconnect.changeevent.PythonServerConnectionChangeEvent;
import com.ohgiraffers.finalproject.news.pythonconnect.service.ConnectionChecker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;



@Component
public class ConnectionStatusManager {

    // Python 서버에 현재 연결되어 있는지의 상태를 저장
    private boolean connectedToPythonServer = false;

    // Python 서버 연결을 확인
    private ConnectionChecker connectionChecker;

    @Autowired
    public void setConnectionChecker(@Lazy ConnectionChecker connectionChecker) {
        this.connectionChecker = connectionChecker;
    }

    // Spring의 이벤트 발행 기능을 사용하기 위한 인터페이스
    @Autowired
    private ApplicationEventPublisher eventPublisher;




    // Python 서버에 현재 연결되어 있는지 확인
    public boolean isConnectedToPythonServer() {
        return this.connectedToPythonServer;
    }

    // Python 서버의 연결 상태를 설정하고, 상태 변경 시 이벤트를 발행
    public void setConnectedToPythonServer(boolean connected) {
        boolean oldStatus = this.connectedToPythonServer;
        this.connectedToPythonServer = connected;
        // 연결 상태가 변경되었을 경우에만 발행
        if(oldStatus != connected) {
            eventPublisher.publishEvent(new PythonServerConnectionChangeEvent(this, connected));
        }
    }



    // ConnectionChecker를 사용하여 Python 서버와의 연결을 확인
    public void checkConnection() {
        connectionChecker.checkPythonConnection();
    }


}
