import React,{useState, useEffect} from 'react'
import { Link } from 'react-router-dom'
import { Typography, Tag, Tooltip, Input, Button, message, Switch } from 'antd'
import { EditOutlined, DeleteOutlined, ToolOutlined } from '@ant-design/icons'
import axios from 'axios'
import io from '@common/io-context'
import PluginAddModal from './plugin-add-modal'

const { Title, Text } = Typography
const Cm = () => {
  const [visible, setVisible] = useState(false)
  const [pluginList, setPluginList] = useState([])
  const [curRecord, setCurRecord] = useState(null)
  const [curType, setCurType] = useState('Add')
  const pluginListMap = {}

  const getPluginList = async () => {
    try {
      const res = await io.get('/plugins')
      setPluginList(res?.list || [])
    } catch (error) {
      message.error(error)
    }
  }

  const onCancel = () => {
    setVisible(false)
  }

  const onChangeDefault = async (checked, e, record) => {
    console.log(checked, e, record)
    try {
      const res = await io.put(`/plugins/${record.pluginId}/default`)
      res && getPluginList()
    } catch (error) {
      message.error(error)
    }
  }

  useEffect(() => {
    // getCatalogList()
    getPluginList()
  }, [])
  
  pluginList.forEach(t => {
    pluginListMap[t.pluginId] = t.pluginName
  })

  const addModalProps = {
    visible,
    onCancel:onCancel,
    // getCatalogList,
    type: curType,
    pluginList,
    record: curRecord,
  }

  return (
    <div>
      <div className='m8 p16 white-bg'>
        <div className='fs28 mb16'>Plugin</div>
        {/* <Text>
        xxx  
        </Text> */}
      </div>
      <div className='m8 p24 main white-bg'>
        <div className='catalog-top-bar FBH FBJ mb16'>
          <div></div>
          <div>
            {/* <Input.Search placeholder="keywords"  size="small" style={{width: '200px'}} /> */}
            <Button type='primary' size="small" className='ml8'
              onClick={() => {
                setCurType('Add')
                setVisible(true)
              }}
              disabled
            >Add</Button>
            <PluginAddModal {...addModalProps} />
          </div>
        </div>
        {/* plugin-list */}
        <div className='catalog-list'>
          {
            pluginList?.map(t => 
              <div className='list-item FBH FBJS gray-bd r4 p16 mb24'>
                <div className='item-logo pr24 fs24 mr8 fc8'>
                  <ToolOutlined />
                </div>
                <div className='item-content'>
                  <div className='item-top FBH FBJ mb16'>
                    <div>
                      {/* <Link className='fs24 mr8 fc0' to={`/catalog/${t.catalogId}`}> */}
                      <span className='fs24 mr8 fc0'>
                        {t.pluginName}
                      </span>
                      {/* </Link>  */}
                    {t.defaultPlugin && <Tag>default</Tag>}
                    </div>
                    
                    <div className='options'>
                    {
                      !t.defaultPlugin &&
                      <div>
                        set default
                        <Switch className='ml8' defaultChecked={t.defaultPlugin} onChange={(checked, e) => onChangeDefault(checked, e, t)} />
                      </div>
                    }
                    </div>
                    {/* <div className='options'>
                      <Tooltip title="edit">
                        <EditOutlined className='fc4 mr16 hand' onClick={() => {
                          setCurType('Edit')
                          setVisible(true)
                          setCurRecord(t)
                        }} />
                      </Tooltip>
                      <Tooltip title="delete">
                        <DeleteOutlined className='fc4 mr12 hand' />
                      </Tooltip>
                      <Tooltip title="more">
                        <MoreOutlined className='fc4 hand' />
                      </Tooltip>
                    </div> */}
                  </div>
                  <div className='item-info FBH FBJ'>
                    <span className='i-label'>Describe：{t.descr || '--'}</span>
                  </div>
                </div>
                
              </div>
            )
          }
          
        </div>
      </div>
    </div>
  )
}
export default Cm