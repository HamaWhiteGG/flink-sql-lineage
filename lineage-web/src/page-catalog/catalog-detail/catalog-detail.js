import React,{useState, useEffect} from 'react'
import { useParams, useOutletContext, Outlet } from 'react-router-dom'
import { message, Tabs, Breadcrumb, Empty } from 'antd'
import { TableOutlined, FunctionOutlined } from '@ant-design/icons'
import DetailTree from './detail-tree'
import io from '@common/io-context'

const Cm = () => {
  const { id: catalogId, databaseName, itemId } = useParams()
  const [catalogDetail, setCatalogDetail] = useState({})
  const [databaseList, setDatabaseList] = useState([])
  const [databaseFunList, setDatabaseFunList] = useState([])
  const [databaseTableList, setDatabaseTableList] = useState([])
  const [activeKey, setActiveKey] = useState('table')
  
  // get catalog detail
  const getCatalogDetail = async () => {
    try {
      const res = await io.get(`/catalogs/${catalogId}`)
      setCatalogDetail(res)
    } catch (error) {
      message.error(error)
    }
  }
  // get databases under this catalog
  const getDatabases = async () => {
    try {
      const res = await io.get(`/catalogs/${catalogId}/databases`)
      console.log('0000',res)
      setDatabaseList(res || [])
    } catch (error) {
      message.error(error)
    }
  }

  // get databases under this catalog
  const getDatabasesFun = async databaseName => {
    try {
      const res = await io.get(`/catalogs/${catalogId}/databases/${databaseName}/functions`)
      setDatabaseFunList(res.list?.map(t => {return {title: t.functionName, key: t.functionId}}))
      return res.list
    } catch (error) {
      message.error(error)
    }
  }

  // get databases under this catalog
  const getDatabasesTable = async databaseName => {
    try {
      const res = await io.get(`/catalogs/${catalogId}/databases/${databaseName}/tables`)
      setDatabaseTableList(res)
      return res
    } catch (error) {
      message.error(error)
    }
  }

  const onChangeTab = (val) => {
    setActiveKey(val)
  }

  useEffect(() => {
    getCatalogDetail()
    getDatabases()
  }, [])

  const tabsMap = {
    table: getDatabasesTable,
    function: getDatabasesFun,
  }

  const DetailTreeProps = {
    catalogDetail,
    databaseList,
    databaseFunList,
    databaseTableList,
    type: activeKey,
    getChildren: tabsMap[activeKey],
    databaseName,
    itemId,
  }

  const DetaiInfoProps = {
    catalogDetail,
    databaseName,
    itemId,
  }
  
  return (
    <div className='FBH FBJ'>
      <div className='left-tree-box white-bg p16'>
        <Breadcrumb separator="<">
          <Breadcrumb.Item href="#/catalog">Catalogs</Breadcrumb.Item>
          <Breadcrumb.Item>{catalogDetail?.catalogName || '--'}</Breadcrumb.Item>
        </Breadcrumb> 
        <Tabs
          defaultActiveKey="table"
          items={[{
            label: <span><TableOutlined/>Table</span>,
            key: 'table',
            children: <DetailTree {...DetailTreeProps} />,
          }, {
            label: <span><FunctionOutlined/>Funtion</span>,
            key: 'function',
            children: <DetailTree {...DetailTreeProps} />,
          }]}
          activeKey={activeKey}
          onChange={onChangeTab}
        />
      </div>
      <div className='white-bg'  style={{width: '100%'}}>
      {
        itemId ? <Outlet context={{...DetaiInfoProps}} /> : <Empty />
      }
      </div>
    </div>
  )
}
export default Cm