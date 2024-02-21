import React from 'react';
import {BrowserRouter, NavLink, Route, Routes} from "react-router-dom";
import Layout from "./components/layouts/Layout";
import News from "./page/News";
function App() {




  return (
    <>
      <BrowserRouter>
        <Routes>
          <Route path='/' element={<Layout/>}>
              <Route path=':category' element={<News/>}/>
          </Route>
        </Routes>
      </BrowserRouter>
    </>
  );
}

export default App;

