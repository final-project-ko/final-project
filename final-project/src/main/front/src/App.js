import React from 'react';
import {BrowserRouter, NavLink, Route, Routes} from "react-router-dom";
import Layout from "./components/layouts/Layout";
import HeaderNews from "./page/news/HeaderNews";
import DetailsNews from "./page/news/DetailsNews";
import CustomerPage from "./page/qna/CustomerPage";
import Mypage from "./page/mypage/Mypage";
import AdminMain from "./page/admin/AdminMain";
import AdminDash from "./page/admin/pages/AdminDash";
import AdminUser from "./page/admin/pages/AdminUser";
import AdminContent from "./page/admin/pages/AdminContent";
import AdminSetting from "./page/admin/pages/AdminSetting";
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
          </Route>
          <Route path='/admin' element={<AdminMain/>}>
              <Route path='/admin/dash' element={<AdminDash/>}/>
              <Route path='/adminUser' element={<AdminUser/>}/>
              <Route path='/adminContent' element={<AdminContent/>}/>
              <Route path='/adminSetting' element={<AdminSetting/>}/>
          </Route>
        </Routes>
      </BrowserRouter>
    </>
  );
}

export default App;

