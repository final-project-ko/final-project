import {Outlet} from "react-router-dom";
import Navbar from "../commons/Navbar";
import Footers from "../commons/Footer";


const Layout = () => {

    return(
        <>
            <Navbar/>
            <Outlet/>
            <Footers/>
        </>
    )
}
export default Layout;