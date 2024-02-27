import {useNavigate, useParams} from "react-router-dom";
import "../../components/css/HeaderNews.css";
import DetailsNews from "./DetailsNews";
import {useEffect, useState} from "react";

const HeaderNews = () => {

                           // 파라미터 값을 url을 통해 넘겨받은 페이지에서 사용할 수 있도록 해줌.
    let {category} = useParams();


    if(category===undefined){
        category = "kr_total";
    }
    console.log(category);
    // 카테고리 안에 기본은 main 나머지는 각 카테고리 이름을 담고 있음.. 그 카테고리 기사를 받아와 각 news에 뿌려주는 로직 작성 필요

    const navigate = useNavigate();

    const onClickHandler = (article) => {

        navigate(`/detailNews/${article.code}`, {state : {article}});
    }

    // 선택 category별 new 호출 로직
    // const [title, setTitle] = useState();
    // const [description, setDescription] = useState();
    // const [url, setUrl] = useState();
    // const [image, setImage] = useState();
    const [articles, setArticles] = useState([]);

    useEffect(() => {
        const fetchCategoryNews = async () => {
            try {
                const promise = await fetch(`http://localhost:8080/api/news/categoryNews/${category}`)
                                                .then(response => response.json())
                                                .then(data => {
                                                    setArticles(data.articles);
                                                    console.log("data", data);
                                                })
            } catch (error) {
                console.log("Error fetching data", error);
            }
        };
        fetchCategoryNews();
    }, [category]);


    return(
        <div className='mainDiv'>
            {articles.map((article, index) => (
                <button className="new1" id={`news${index + 1}`} key={index} onClick={() => onClickHandler(article)}>
                    <img className="newsImage" src={article.image} width="90%" height="55%" alt={article.title} />
                    <div className="newsText">{article.title}</div>
                </button>
            ))}
        </div>
    )
}
export default HeaderNews;