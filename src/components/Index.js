import React from "react";
import { useAtom } from "jotai";

import state from "../stateManager";
import Card from "./Card";

const Index = () => {
    const [cards] = useAtom(state.cardsAtom);

    return (
        <div className="row">
            {cards.map((card, i) => (
                <Card key={i} {...card} />
            ))}
        </div>
    );
};

export default Index;
