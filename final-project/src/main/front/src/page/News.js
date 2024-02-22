import {useParams} from "react-router-dom";
import "../components/css/News.css";

const News = () => {

                           // 파라미터 값을 url을 통해 넘겨받은 페이지에서 사용할 수 있도록 해줌.
    let {category} = useParams();

    console.log(category);



    return(
        <div className='mainDiv'>
            <div className="new1" id='news'></div>
            <div className="new1" id='news'></div>
            <div className="new1" id='news'></div>
            <div className="new1" id='news'></div>
            <div className="new1" id='news'></div>
            <div className="new1" id='news'></div>
            <div className="new1" id='news'></div>
            <div className="new1" id='news'></div>
            <div className="new1" id='news'></div>
            <div className="new1" id='news'></div>
        </div>
    )
}
export default News;