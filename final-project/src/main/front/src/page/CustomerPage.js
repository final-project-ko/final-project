import "../components/css/CustomerPage.css";
import { FaSearch } from "react-icons/fa";
const CustomerPage = () => {


    return (
        <>
            <div className="customerMent">
                오늘은 서비스를 이용 하시는 데 도움이 필요 하신가요?
            </div>
            <div className="searchBar">
                <input type="text" className="searchText" placeholder="도움말을 검색 해보세요"/>
                <button className="serchBtn"><FaSearch  size="30" color="gray"/></button>
            </div>

            <div className="searchMenu">
            <ul className='searchUl'>
                <li>자주 하는 질문</li>
                <li>기본 안내</li>
                <li>공지 사항</li>
                <li>1대1 문의</li>
            </ul>
            </div>


        </>
    )

}
export default CustomerPage;