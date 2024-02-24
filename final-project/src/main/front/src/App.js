import React from 'react';
import {BrowserRouter, NavLink, Route, Routes} from "react-router-dom";
import Layout from "./components/layouts/Layout";
import HeaderNews from "./page/HeaderNews";
import DetailsNews from "./page/DetailsNews";
function App() {




  return (
    <>
      <BrowserRouter>
        <Routes>
          <Route path='/' element={<Layout/>}>
              <Route index element={<HeaderNews/>}/>
              <Route path=':category' element={<HeaderNews/>}/>
              <Route path='/detailNews' element={<DetailsNews/>}/>
          </Route>
        </Routes>
      </BrowserRouter>
    </>
  );
}

export default App;

