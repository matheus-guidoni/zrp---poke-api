import './App.css';
import axios from 'axios';
import React, { useState } from 'react';
import Button from '@mui/material/Button';

export const App = () => {
  const [pokemonName, setPokemonName] = useState('');
  const [pokemonDetails, setPokemonDetails] = useState(null);
  const [pokemonAbilities, setPokemonAbilities] = useState([]);
  const [showFrontImage, setShowFrontImage] = useState(true);
  const [errorMessage, setErrorMessage] = useState('');

  const handleSearch = async () => {
    try {
      const detailsResponse = await axios.get(`http://localhost:8080/api/pokemons/${pokemonName}/details`);
      const abilitiesResponse = await axios.get(`http://localhost:8080/api/pokemons/${pokemonName}`);
      setPokemonDetails(detailsResponse.data);
      setPokemonAbilities(abilitiesResponse.data);
      setErrorMessage('');
    } catch (error) {
      console.error('Error fetching pokemon details:', error);
      setPokemonDetails(null);
      setPokemonAbilities([]);
      setErrorMessage('Pokemon not found');
    }
  };

  const toggleImage = () => {
    setShowFrontImage(!showFrontImage);
  };

  const capitalizeFirstLetter = (string) => {
    return string.charAt(0).toUpperCase() + string.slice(1);
  };

  return (
    <div className="pokedex-container">
      <div className="pokedex-screen">
        <div className="top-bar">
          <span className="search-label">PokeSearch:</span>
          <input
            className="search-input"
            type="text"
            placeholder="Pokemon name"
            value={pokemonName}
            onChange={(e) => setPokemonName(e.target.value)}
          />
        </div>
        <div className="button-search">
          <Button
            variant="contained"
            color="error"
            size="small"
            sx={{
              textTransform: 'none',
              fontWeight: 'bold',
              padding: '5px 15px',
              borderRadius: '5px',
            }}
            onClick={handleSearch}
          >
            Search
          </Button>
        </div>

        {errorMessage && (
          <div className="error-message">
            {errorMessage}
          </div>
        )}

        {pokemonDetails && (
          <div className="pokemon-display">
            <button className="arrow-btn left-arrow" onClick={toggleImage}>{"<"}</button>
            <span className="display-mode default-mode">Front</span>
            <span className="display-mode shiny-mode">Back</span>
            <button className="arrow-btn right-arrow" onClick={toggleImage}>{">"}</button>
            <div className="pokemon-image-container">
              <div className="pokemon-image">
                <img
                  src={showFrontImage ? pokemonDetails.frontImageUrl : pokemonDetails.backImageUrl}
                  alt="pokemon"
                />
              </div>
            </div>
          </div>
        )}

        {pokemonDetails && (
          <div className="stats-table">
            <div className="stats-header">
              <span className="base-header">Base</span>
              <span className="stats-header-title">Stats</span>
            </div>
            {pokemonDetails.stats.map((stat) => (
              <div className="stats-row" key={stat.name}>
                <span className="stat-label">{capitalizeFirstLetter(stat.name)}:</span>
                <span className="stat-value">{stat.value}</span>
              </div>
            ))}
            <div className="stats-row">
              <span className="stat-label">Abilities:</span>
              <span className="stat-value">
                {pokemonAbilities.map((ability) => capitalizeFirstLetter(ability)).join(', ')}
              </span>
            </div>
          </div>
        )}
      </div>
    </div>
  );
};