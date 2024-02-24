import {NavLink} from "react-router-dom";
import "../css/Navbar.css";
import {useEffect, useState} from "react";
import { BiWorld } from "react-icons/bi";
import { FcGlobe } from "react-icons/fc";

const Navbar = () => {

    const [toggle,setToggle] = useState(false);


    const onClickHanlder = () => {
        setToggle(!toggle);
    }


    const set = toggle? <BiWorld  size="41" color="gray"/> : <FcGlobe  size="40"/>

    const nonChoice = {
        background: 'transparent',
        border: 0,
        cursor: 'pointer',
        fontSize: '1.1rem',
        textDecoration : 'none',
        color:'black'
    }
    const choice = {
        color:"#008BDA",
        background: 'transparent',
        border: 0,
        cursor: 'pointer',
        fontSize: '1.1rem',
        textDecoration : 'none',
    }

    return (
        <>
            <header className='navBox'>

                <div className='mainH1'>
                    <NavLink className='mainPage' to={"/main"}>오늘은</NavLink>
                </div>

                <ul className='mainUl'>
                    <li><NavLink  to={"/main"} className='main' style={({isActive}) => (isActive? choice : nonChoice)}>종합</NavLink></li>
                    <li><NavLink  to={"/business"} className='business' style={({isActive}) => (isActive? choice : nonChoice)}>비즈니스</NavLink></li>
                    <li><NavLink  to={"/entertainment"} className='entertainment' style={({isActive}) => (isActive? choice : nonChoice)}>엔터테인먼트</NavLink></li>
                    <li><NavLink  to={"/technology"} className='technology' style={({isActive}) => (isActive? choice : nonChoice)}>기술</NavLink></li>
                    <li><NavLink  to={"/science"} className='science' style={({isActive}) => (isActive? choice : nonChoice)}>과학</NavLink></li>
                    <li><NavLink  to={"/sports"} className='sports' style={({isActive}) => (isActive? choice : nonChoice)}>스포츠</NavLink></li>
                    <li><NavLink  to={"/health"} className='health' style={({isActive}) => (isActive? choice : nonChoice)}>건강</NavLink></li>
                    <li><NavLink  to={"/general "} className='Art' style={({isActive}) => (isActive? choice : nonChoice)}>일반</NavLink></li>
                </ul>

                {/*로그인 만들때 사용할 div*/}
                <div className='loginDiv'>
                    Login
                </div>
                {/*추가로 로그인 완료 시 마이페이지로 보내는 기능도 만들어야 함*/}
            </header>

            <button className='toggle' onClick={onClickHanlder}>{set}</button>


        </>
    )
}

export default Navbar;