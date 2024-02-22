import {NavLink} from "react-router-dom";
import "../css/Navbar.css";
import {useEffect} from "react";


const Navbar = () => {

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
                    <li><NavLink  to={"/politics"} className='politics' style={({isActive}) => (isActive? choice : nonChoice)}>정치</NavLink></li>
                    <li><NavLink  to={"/business"} className='business' style={({isActive}) => (isActive? choice : nonChoice)}>비즈니스</NavLink></li>
                    <li><NavLink  to={"/technology"} className='technology' style={({isActive}) => (isActive? choice : nonChoice)}>기술</NavLink></li>
                    <li><NavLink  to={"/realestate"} className='realestate' style={({isActive}) => (isActive? choice : nonChoice)}>부동산</NavLink></li>
                    <li><NavLink  to={"/science"} className='science' style={({isActive}) => (isActive? choice : nonChoice)}>과학</NavLink></li>
                    <li><NavLink  to={"/sports"} className='sports' style={({isActive}) => (isActive? choice : nonChoice)}>스포츠</NavLink></li>
                    <li><NavLink  to={"/world"} className='world' style={({isActive}) => (isActive? choice : nonChoice)}>세계</NavLink></li>
                    <li><NavLink  to={"/health"} className='health' style={({isActive}) => (isActive? choice : nonChoice)}>건강</NavLink></li>
                    <li><NavLink  to={"/Art"} className='Art' style={({isActive}) => (isActive? choice : nonChoice)}>아트</NavLink></li>
                    <li><NavLink  to={"/fashion"} className='fashion' style={({isActive}) => (isActive? choice : nonChoice)}>패션</NavLink></li>
                </ul>

                <div className='loginDiv'>
                    Login
                </div>
            </header>
        </>
    )
}

export default Navbar;