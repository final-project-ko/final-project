import "../../components/css/Mypage.css";
import {useNavigate} from "react-router-dom";
import { FaRegUserCircle } from "react-icons/fa";
const Mypage = () => {

    const navigate = useNavigate();
    const onClickHandler = () => {

        navigate("/detailNews")
    }
    return (
        <>
            <div className="myPage">
            <div className="userDiv">

                <div className="userImg">
                    <FaRegUserCircle size="150" color="#7CF2FF" style={{backgroundColor:"white"}}/>
                </div>
                <div className="userName">
                    <h2 style={{backgroundColor:"white"}}>정민식 님</h2>
                    <h3 style={{backgroundColor:"white"}}>jmsdew@naver.com</h3>
                </div>
                <ul className="userUl">
                    <li>북마크 목록</li>
                    <li>이용 약관</li>
                    <li>계정 관리</li>
                </ul>
            </div>

            <h3 className="myPageText"> > 북마크 목록</h3>
            <div className='myPageDiv'>
                {/* img, title 카테고리별 기사에서 꺼내오는 코드로 바꾸어야 함 */}
                <button className="news" id='news1' onClick={onClickHandler}>

                </button>
                <button className="news" id='news2'>

                </button>
                <button className="news" id='news3'></button>
                <button className="news" id='news4'></button>
                <button className="news" id='news5'></button>
                <button className="news" id='news6'></button>
                <button className="news" id='news7'></button>
                <button className="news" id='news8'></button>
            </div>
            </div>
        </>
    )

}
export default Mypage;