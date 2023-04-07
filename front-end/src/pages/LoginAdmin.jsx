import React from 'react'
import styles from './Login.module.scss'
import LoginValidationAdmin from '../components/LoginValidationAdmin'
import Navbar from '../components/Navbar'
import Footer from '../components/Footer'

// realizar as  api's
export default function Login() {
  return (
    <div className={styles.appLogin}>
      <div className={styles.bodyLogin}>
        <Navbar />
        <LoginValidationAdmin />
        <Footer />
      </div>
    </div>
  )
}
