import "../../components/css/AdminMain.css";
import {NavLink} from "react-router-dom";
const AdminMain = () => {

    const nonChoice = {
        background: 'transparent',
        border: 0,
        cursor: 'pointer',
        fontSize: '1.1rem',
        textDecoration : 'none',
        color:'black'
    }
    const choice = {
        color:"white",
        backgroundColor: "#8d8d8d",
        border: 0,
        cursor: 'pointer',
        fontSize: '1.1rem',
        textDecoration : 'none',
    }

    return (
        <>
            <div className="adminDiv">
                <div className="adminMainText">오늘은</div>
                <button className="adminLogOut">로그아웃</button>

            </div>

            <div className="adminNav">
                <ul className="adminUl">
                    <li><NavLink to={"/"} style={({isActive}) => (isActive? choice : nonChoice)}>사이트 바로가기</NavLink></li>
                    <li><NavLink to={"/admin/dash"} style={({isActive}) => (isActive? choice : nonChoice)}>대시보드</NavLink></li>
                    <li><NavLink to={"/adminUser"} style={({isActive}) => (isActive? choice : nonChoice)}>회원관리</NavLink></li>
                    <li><NavLink to={"/adminContent"} style={({isActive}) => (isActive? choice : nonChoice)}>콘텐츠</NavLink></li>
                    <li><NavLink to={"/adminSetting"} style={({isActive}) => (isActive? choice : nonChoice)}>설정</NavLink></li>
                </ul>
            </div>
        </>
    )
}
export default AdminMain;