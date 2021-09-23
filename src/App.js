import { BrowserRouter as Router, Switch, Route } from "react-router-dom";
import { useEffect } from "react";
import { useAtom } from "jotai";
import axios from "axios";
import state from "./stateManager";

import Header from "./components/Header";
import Index from "./components/Index";
import Country from "./components/Country";
import Genre from "./components/Genre";
import About from "./components/About";

const App = () => {
    const [country] = useAtom(state.currentCountryAtom);
    const [keyword] = useAtom(state.currentKeywordAtom);
    const [genre] = useAtom(state.currentGenreAtom);
    const [services] = useAtom(state.servicesAtom);
    const [_cards, setCards] = useAtom(state.cardsAtom);

    const fetchData = async (service = "netflix") => {
        try {
            let options = {
                method: "GET",
                url: `https://streaming-availability.p.rapidapi.com/search/basic`,
                headers: {
                    "x-rapidapi-host": "streaming-availability.p.rapidapi.com",
                    "x-rapidapi-key":
                        "f7ec7c7f71msh560ad9410ceaeccp101c1fjsn8491093b056f",
                },
                params: {
                    country: country,
                    service: service,
                    keyword: keyword,
                    genre: genre,
                    type: "movie",
                },
            };

            const req = await axios.request(options);
            return req;
        } catch (err) {
            console.error(err);
        }
    };

    useEffect(() => {
        const cardsLoader = async () => {
            const serviceList = Object.keys(services).filter((s) =>
                services[s].includes(country)
            );
            let cards = [];

            for (let serv of serviceList) {
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
            }
        };

        cardsLoader();
    }, [country, keyword, genre]);

    return (
        <Router>
            <Header />
            <div className="container mt-3">
                <Switch>
                    <Route exact path="/country/:country">
                        <Country />
                    </Route>
                    <Route exact path="/genre/:genre">
                        <Genre />
                    </Route>
                    <Route exact path="/about">
                        <About />
                    </Route>

                    <Route exact path="/">
                        <Index />
                    </Route>
                </Switch>
            </div>
        </Router>
    );
};

export default App;
