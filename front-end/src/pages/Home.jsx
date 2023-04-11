import React from 'react'
import MainSection from '../components/MainSection'
import Navbar from '../components/Navbar'
import Footer from '../components/Footer'
import { useLocation } from 'react-router-dom'

export default function Home() {

    const location = useLocation()
    localStorage.setItem('currentLocation', location.pathname)

    return (
        <>
            <Navbar />
            <MainSection />
            <Footer />
        </>
    )
}