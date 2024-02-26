import {useLocation} from "react-router-dom";

const DetailsNews = () => {

    const location = useLocation();
    const { article } = location.state; // 선택한 기사 article 정보를 가져옴

    return (
        <div className='detailsNewsDiv'>
            <div className='selectedNewsDiv'>
                <img className='detailsNewsImg' src={article.image}/>
                <span className='detailsNewsTitle'>{article.title}</span>
                <span className='detailsNewsDescription'>With “Part Two” hitting theaters, they discuss another potential sequel, the impossible quest for onscreen perfection and those infamous popcorn buckets.</span>
                <span className='detailsNewsLinkText'>
                    If you're curious about the back story?&nbsp;&nbsp;
                    <a className='detailsNewsLink' href="https://www.nytimes.com/2024/02/21/movies/dune-timothee-chalamet-villeneuve.html" target='_blank'>Continue reading</a>
                </span>


            </div>
            <div className='recommandNewsDiv'>

            </div>
        </div>
    )

}

export default DetailsNews;