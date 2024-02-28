import {useNavigate} from "react-router-dom";
import {useEffect} from "react";
import axios from "axios";

const LoginHandler = (props) => {

    // redirect한 요청 중 회원 코드 뽑아오기
    const navigate = useNavigate();
    const code = new URL(window.location.href).searchParams.get("code");

    useEffect(() => {
        const kakaoLogin = async () => {
            await axios({
                method: "GET",
                url: `${process.env.REACT_APP_REDIRECT_URL}/?code=${code}`,
                headers : {
                    "Content-type" : "application/json;charset=utf-8"
                },
            }).then((res) => {
                localStorage.setItem("name", res.data.account.kakaoName);
                localStorage.setItem("email", res.data.account.kakaoEmail);
                navigate("/");
            });
        };
        kakaoLogin();
    }, [props.history]);

    return (
        <div className="LoginHandeler">
            <div className="notice">
                <p>로그인 중입니다.</p>
                <p>잠시만 기다려주세요.</p>
                <div className="spinner"></div>
            </div>
        </div>
    );
}

export default LoginHandler;