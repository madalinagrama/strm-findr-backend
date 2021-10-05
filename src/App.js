import React, { useEffect, useState } from "react";
import { BrowserRouter as Router, Switch, Route } from "react-router-dom";
import { useAtom } from "jotai";
import axios from "axios";
import state from "./stateManager";

import Header from "./components/Header";
import Index from "./components/Index";
import Country from "./components/Country";
import Genre from "./components/Genre";
import About from "./components/About";
import AuthPage from "./pages/AuthPage";
import ProfilePage from "./pages/ProfilePage";
import Spinner from "./components/Spinner";

import "./App.css";

const App = () => {
    const [country] = useAtom(state.currentCountryAtom);
    const [keyword] = useAtom(state.currentKeywordAtom);
    const [genre] = useAtom(state.currentGenreAtom);
    const [services] = useAtom(state.servicesAtom);
    const [_cards, setCards] = useAtom(state.cardsAtom);

    const [loading, setLoading] = useAtom(state.loadingAtom);

    const fetchData = async (service = "netflix") => {
        try {
            let options = {
                method: "GET",
                url: process.env.REACT_APP_URL,
                headers: {
                    "x-rapidapi-host": "streaming-availability.p.rapidapi.com",
                    "x-rapidapi-key": process.env.REACT_APP_API_KEY,
                },
                params: {
                    country: country,
                    service: service,
                    keyword: keyword,
                    genre: genre,
                    type: "series",
                },
            };

            const req = await axios.request(options);
            console.log(req);
            return req;
        } catch (err) {
            console.error(err);
        }
    };

    useEffect(() => {
        const cardsLoader = async () => {
            let cards = [];

            for (let serv of services) {
                let data = await fetchData(serv);
                if (data) {
                    cards.push(
                        data.data.results.map((r) => ({
                            image: r.posterURLs["original"],
                            title: r.originalTitle,
                            overview: r.overview.slice(0, 150) + "...",
                            id: r.imdbID,
                            service: serv,
                        }))
                    );
                    cards = cards.reduce((a, v) => a.concat(v), []);
                }
            }

            if (cards.length) {
                setCards(cards);
                setLoading(false);
            }
        };

        cardsLoader();
    }, [keyword]);

    return (
        <Router>
            <Header />
            {loading && <Spinner />}
            {!loading && (
                <div className="container mt-3">
                    <Switch>
                        <Route path="/country/:country">
                            <Country />
                        </Route>
                        <Route path="/genre/:genre">
                            <Genre />
                        </Route>
                        <Route path="/about">
                            <About />
                        </Route>

                        <Route exact path="/login">
                            <AuthPage />
                        </Route>

                        <Route exact path="/profile">
                            <ProfilePage />
                        </Route>

                        <Route exact path="/">
                            <Index />
                        </Route>
                    </Switch>
                </div>
            )}
        </Router>
    );
};

export default App;
