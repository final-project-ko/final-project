import React from 'react';
import {BrowserRouter, NavLink, Route, Routes} from "react-router-dom";
import Layout from "./components/layouts/Layout";
import HeaderNews from "./page/news/HeaderNews";
import DetailsNews from "./page/news/DetailsNews";
import CustomerPage from "./page/qna/CustomerPage";
import Mypage from "./page/mypage/Mypage";
import AdminMain from "./page/admin/AdminMain";
import Login from "./page/login/Login";
import LoginHandler from "./page/login/LoginHandler";

function App() {




  return (
    <>
      <BrowserRouter>
        <Routes>
          <Route path='/' element={<Layout/>}>
              <Route index element={<HeaderNews/>}/>
              <Route path=':category' element={<HeaderNews/>}/>
              <Route path='/detailNews' element={<DetailsNews/>}/>
              <Route path='/customer' element={<CustomerPage/>}/>
              <Route path='/mypage' element={<Mypage/>}/>
              <Route path='/login' element={<Login/>}/>
          </Route>
        <Route path='/admin' element={<AdminMain/>}/>
        <Route path='/login/oauth' element={<LoginHandler/>}/>
        </Routes>
      </BrowserRouter>
    </>
  );
}

export default App;

