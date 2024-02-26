import React from 'react';
import {BrowserRouter, NavLink, Route, Routes} from "react-router-dom";
import Layout from "./components/layouts/Layout";
import HeaderNews from "./page/HeaderNews";
import DetailsNews from "./page/DetailsNews";
import CustomerPage from "./page/CustomerPage";
import Mypage from "./page/Mypage";
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
        </Routes>
      </BrowserRouter>
    </>
  );
}

export default App;

