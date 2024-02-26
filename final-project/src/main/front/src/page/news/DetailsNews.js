

const DetailsNews = () => {

    return (
        <div className='detailsNewsDiv'>
            <div className='selectedNewsDiv'>
                <img className='detailsNewsImg' src="https://static01.nyt.com/images/2024/03/03/multimedia/03CHALAMET-VILLENEUVE-03-pmlf/03CHALAMET-VILLENEUVE-03-pmlf-thumbLarge.jpg"/>
                <span className='detailsNewsTitle'>Denis Villeneuve and Timothée Chalamet: ‘Dune’ Dynasty</span>
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