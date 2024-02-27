import React, {useState} from 'react';
import {BrowserRouter, NavLink, Route, Routes} from "react-router-dom";
import Layout from "./components/layouts/Layout";
import HeaderNews from "./page/news/HeaderNews";
import DetailsNews from "./page/news/DetailsNews";
import CustomerPage from "./page/qna/CustomerPage";
import Mypage from "./page/mypage/Mypage";
import AdminMain from "./page/admin/AdminMain";

function App() {
    const [toggle, setToggle] = useState(true);



  return (
    <>
      <BrowserRouter>
        <Routes>
          <Route path='/' element={<Layout toggle={toggle} setToggle={setToggle}/>}>
              <Route index element={<HeaderNews/>}/>
              <Route path=':category' element={<HeaderNews/>}/>
              <Route path='/detailNews/:articleCode' element={<DetailsNews toggle={toggle}/>}/>
              <Route path='/customer' element={<CustomerPage/>}/>
              <Route path='/mypage' element={<Mypage/>}/>
          </Route>
          <Route path='/admin' element={<AdminMain/>}>
          </Route>
        </Routes>
      </BrowserRouter>
    </>
  );
}

export default App;

