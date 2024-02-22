import {useNavigate, useParams} from "react-router-dom";
import "../components/css/HeaderNews.css";
import DetailsNews from "./DetailsNews";

const HeaderNews = () => {

                           // 파라미터 값을 url을 통해 넘겨받은 페이지에서 사용할 수 있도록 해줌.
    let {category} = useParams();


    if(category===undefined){
        category = "main";
    }
    console.log(category);
    // 카테고리 안에 기본은 main 나머지는 각 카테고리 이름을 담고 있음.. 그 카테고리 기사를 받아와 각 news에 뿌려주는 로직 작성 필요

    const navigate = useNavigate();

    const onClickHandler = () => {

        navigate("/fashion")
    }

    return(
        <div className='mainDiv'>
            {/* img, title 카테고리별 기사에서 꺼내오는 코드로 바꾸어야 함 */}
            <button className="new1" id='news1' onClick={onClickHandler}>
                <img className="newsImage" src="https://static01.nyt.com/images/2024/03/03/multimedia/03CHALAMET-VILLENEUVE-03-pmlf/03CHALAMET-VILLENEUVE-03-pmlf-thumbLarge.jpg" width="90%" height="50%"/>
                <span className="newsText">Denis Villeneuve and Timothée Chalamet: ‘Dune’ Dynasty</span>
            </button>
            <button className="new1" id='news2'></button>
            <button className="new1" id='news3'></button>
            <button className="new1" id='news4'></button>
            <button className="new1" id='news5'></button>
            <button className="new1" id='news6'></button>
            <button className="new1" id='news7'></button>
            <button className="new1" id='news8'></button>
            <button className="new1" id='news9'></button>
            <button className="new1" id='news10'></button>
        </div>
    )
}
export default HeaderNews;