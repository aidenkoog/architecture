import React from 'react'
import { MENU_TABLE_HEADER_ADDRESS, MENU_TABLE_HEADER_DATE } from '../../../../assets/strings/Strings'
import "./MapTable.css"

/**
 * table component.
 * @param {Any} props 
 * @returns {JSX.Element}
 */
function MapTableComponent(props) {

    /**
     * props devlivered from HomeComponent.
     */
    const { recentHistory } = props

    function getCurrentDate() {
        return recentHistory != null && recentHistory !== "" && recentHistory.length >= 3 ?
            recentHistory.split("|")[2] : "--"
    }

    function getCurrentAddress() {
        return recentHistory != null && recentHistory !== "" && recentHistory.length >= 4 ?
            recentHistory.split("|")[3] : "--"
    }

    return (
        <div>
            <table class="table table-striped">
                <thead>
                    <tr>
                        <th style={{ width: '20%' }}>{MENU_TABLE_HEADER_DATE}</th>
                        <th style={{ width: '80%' }}>{MENU_TABLE_HEADER_ADDRESS}</th>
                    </tr>
                </thead>
            </table>
            {
                recentHistory != null && recentHistory !== "" ?
                    <table class="table_for_td table-striped">
                        <tbody>
                            <tr>
                                <td style={{ width: '20%' }}>{getCurrentDate()}</td>
                                <td style={{ width: '80%' }}>{getCurrentAddress()}</td>
                            </tr>
                        </tbody>
                    </table>
                    :
                    <table class="table_for_td table-striped">
                        <tbody>
                            <tr>
                                <td>ㅤ</td>
                            </tr>
                        </tbody>
                    </table>
            }

        </div>
    )
}

export default MapTableComponent