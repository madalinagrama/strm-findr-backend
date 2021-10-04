import { Fragment } from "react";
import { Link, NavLink } from "react-router-dom";
import { useAtom } from "jotai";

import Dropdown from "./Dropdown";
import logo from "./img/Logo.png";
import header from "./img/Header.png";

import state from "../stateManager";

import ImageSlider from "./ImageSlider";

const Header = () => {
    const [_country, setCountry] = useAtom(state.currentCountryAtom);
    const [_genre, setGenre] = useAtom(state.currentGenreAtom);
    const [keyword, setKeyword] = useAtom(state.currentKeywordAtom);
    const [countries] = useAtom(state.countriesListAtom);
    const [genres] = useAtom(state.genresListAtom);

    const handleCountryChange = (e) => {
        e.preventDefault();
        setCountry(e.target.dataset.id);
    };
    const handleGenreChange = (e) => {
        e.preventDefault();
        console.log("genre is" + e.target.dataset.id);
        setGenre(e.target.dataset.id);
    };

    const searchHandler = async (e) => {
        e.preventDefault();
        setKeyword(e.target.searchBox.value);
    };

    const logoProps = {
        src: logo,
        width: 120,
        height: 24,
    };

    const toggleButtonProps = {
        className: "navbar-toggler",
        type: "button",
        "data-bs-toggle": "collapse",
        "data-bs-target": "#navbarSupportedContent",
        "aria-controls": "navbarSupportedContent",
        "aria-expanded": "false",
        "aria-label": "Toggle navigation",
    };

    const navbarProps = {
        className: "collapse navbar-collapse",
        id: "navbarSupportedContent",
    };

    const navLinkProps = {
        className: "nav-link",
        activeClassName: "active",
        "aria-current": "page",
        exact: true,
    };

    const searchInputProps = {
        type: "text",
        className: "form-control",
        placeholder: "Search title",
        name: "searchBox",
        "aria-label": "Search title",
        "aria-describedby": "searchbutton",
        defaultValue: keyword,
    };

    const searchButtonProps = {
        className: "btn btn-outline-danger",
        type: "submit",
        id: "searchbutton",
    };

    return (
        <Fragment>
            <nav className="navbar navbar-expand-lg navbar-dark bg-dark">
                <div className="container">
                    <Link className="navbar-brand" to="/">
                        <img {...logoProps} alt="strm findr logo" />
                    </Link>
                    <button {...toggleButtonProps}>
                        <span className="navbar-toggler-icon"></span>
                    </button>
                    <div {...navbarProps}>
                        <ul className="navbar-nav me-auto mb-2 mb-lg-0">
                            <li className="nav-item">
                                <NavLink {...navLinkProps} to="/">
                                    Home
                                </NavLink>
                            </li>
                            <li className="nav-item">
                                <NavLink {...navLinkProps} to="/about">
                                    About StrmFindr
                                </NavLink>
                            </li>
                        </ul>

                        <ul className="navbar-nav mb-2 mb-lg-0">
                            <li className="nav-item">
                                <NavLink {...navLinkProps} to="/login">
                                    Login
                                </NavLink>
                            </li>
                            <li className="nav-item">
                                <NavLink {...navLinkProps} to="/register">
                                    Register
                                </NavLink>
                            </li>
                        </ul>
                    </div>
                </div>
            </nav>

            <img src={header} className="img-fluid w-100" alt="" />

            <ImageSlider />

            <div className="container mt-3">
                <div className="row">
                    <div className="col-md-6 col-12">
                        <form onSubmit={searchHandler}>
                            <div className="input-group">
                                <input {...searchInputProps} />
                                <button {...searchButtonProps}>Search</button>
                            </div>
                        </form>
                    </div>
                    <div className="col-md-3 col-12">
                        <Dropdown
                            title="Countries"
                            actions={countries}
                            callback={handleCountryChange}
                        />
                    </div>
                    <div className="col-md-3 col-12">
                        <Dropdown
                            title="Genres"
                            actions={genres}
                            callback={handleGenreChange}
                        />
                    </div>
                </div>
            </div>
        </Fragment>
    );
};

export default Header;
