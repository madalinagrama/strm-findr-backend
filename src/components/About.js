import React from "react";
import { Link } from "react-router-dom";

import { VscGithubInverted } from "react-icons/vsc";

const About = () => {
    return (
        <div>
            <h3>Diana Gradinaru</h3>
            <a href="https://github.com/DianaGradinaru">
                <VscGithubInverted className="git" />
            </a>
        </div>
    );
};

export default About;
