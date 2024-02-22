import {useParams} from "react-router-dom";
import "../components/css/HeaderNews.css";

const HeaderNews = () => {

                           // 파라미터 값을 url을 통해 넘겨받은 페이지에서 사용할 수 있도록 해줌.
    let {category} = useParams();


    if(category===undefined){
        category = "main";
    }
    console.log(category);
    // 카테고리 안에 기본은 main 나머지는 각 카테고리 이름을 담고 있음.. 그 카테고리 기사를 받아와 각 news에 뿌려주는 로직 작성 필요



    return(
        <div className='mainDiv'>
            <button className="new1" id='news1'></button>
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